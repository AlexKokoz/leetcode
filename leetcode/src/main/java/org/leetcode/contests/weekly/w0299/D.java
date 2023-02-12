package org.leetcode.contests.weekly.w0299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int minimumScore(int[] nums, int[][] edges) {
		int n = nums.length;
		int m = edges.length;
		int ans = Integer.MAX_VALUE;

		int[] from = new int[m];
		int[] to = new int[m];
		for (int i = 0; i < m; i++) {
			from[i] = edges[i][0];
			to[i] = edges[i][1];
		}
		int[][] adj = packU(n, from, to);

		int[] xor = new int[n];
		dfs(-1, 0, adj, xor, nums);

		TreeLifting tl = new TreeLifting(adj, 0);
		LCA lca = new LCA(tl);

		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				int par1 = edges[i][0];
				int ch1 = edges[i][1];
				int par2 = edges[j][0];
				int ch2 = edges[j][1];
				if (tl.level(par1) > tl.level(ch1)) {
					int swap = par1;
					par1 = ch1;
					ch1 = swap;
				}
				if (tl.level(par2) > tl.level(ch2)) {
					int swap = par2;
					par2 = ch2;
					ch2 = swap;
				}
//				int lowestCommonAncestor = lca.get(par1, par2);
//				System.out.println(String.format("removing (%d -> %d) (%d -> %d) w lca = %d", par1, ch1,
//						par2, ch2, lowestCommonAncestor));
//				int xor1 = 0, xor2 = 0, xor3 = 0;
				if (lca.get(ch1, par2) == ch1) {
					ans = Math.min(ans, diff(xor[0] ^ xor[ch1], xor[ch1] ^ xor[ch2], xor[ch2]));
				} else if (lca.get(ch2, par1) == ch2) {
					ans = Math.min(ans, diff(xor[0] ^ xor[ch2], xor[ch2] ^ xor[ch1], xor[ch1]));
				} else {
					ans = Math.min(ans, diff(xor[0] ^ xor[ch1] ^ xor[ch2], xor[ch1], xor[ch2]));
				}
			}
		}
		return ans;
	}

	static void dfs(int par, int cur, int[][] adj, int[] xor, int[] nums) {
		xor[cur] = nums[cur];
		for (int ncur : adj[cur]) {
			if (ncur == par)
				continue;
			dfs(cur, ncur, adj, xor, nums);
			xor[cur] ^= xor[ncur];
		}
	}

	static int[][] packU(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++) {
			out[to[i]]++;
			out[from[i]]++;
		}
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++) {
			ret[from[i]][--out[from[i]]] = to[i];
			ret[to[i]][--out[to[i]]] = from[i];
		}
		return ret;
	}

	static int diff(int xor1, int xor2, int xor3) {
		int max = Math.max(xor1, Math.max(xor2, xor3));
		int min = Math.min(xor1, Math.min(xor2, xor3));
		int ans = max - min;
		return ans;
	}

	static class TreeLifting {

		private static final int INIT = -1;
		private final int[][] memo;
		private final int[] level;
		private final int log; // log-base-2(number-of-vertices)
		private final Graph g;

		// adj must be an UNDIRECTED graph
		public TreeLifting(int[][] adj, int root) {
			assert adj != null;
			assert root < adj.length;

			int n = adj.length;
			log = (int) Math.ceil(Math.log(n) / Math.log(2));
			memo = new int[n][log + 1];
			level = new int[n];
			g = new Graph(n);

			// initializations
			for (int[] row : memo)
				Arrays.fill(row, INIT);

			for (int v = 0; v < n; v++)
				for (int u : adj[v])
					g.add(v, u);

			dfs(root, root);
		}

		public TreeLifting(Graph g, int root) {
			assert root < g.V();
			assert g != null;

			int n = g.V();
			log = (int) Math.ceil(Math.log(n) / Math.log(2));
			memo = new int[n][log + 1];
			level = new int[n];
			this.g = g;

			// initializations
			for (int[] row : memo)
				Arrays.fill(row, INIT);

			dfs(root, root);
		}

		private void dfs(final int p, final int ch) {
			memo[ch][0] = p;
			for (int i = 1; i <= log; i++) {
				memo[ch][i] = memo[memo[ch][i - 1]][i - 1];
			}
			for (int nch : g.adj(ch)) {
				if (nch == p)
					continue;
				level[nch] = level[ch] + 1;
				dfs(ch, nch);
			}
		}

		public int parent(final int v, final int leap) {
			validate(v);
			return memo[v][leap];
		}

		public int level(final int v) {
			validate(v);
			return level[v];
		}

		public int log() {
			return log;
		}

		public int V() {
			return g.V();
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			for (int r = 0; r < memo.length; r++) {
				for (int c = 0; c < memo[0].length; c++) {
					sb.append(memo[r][c]).append(" ");
				}
				sb.append("\n");
			}
			return sb.toString();
		}

		private void validate(final int v) {
			assert 0 <= v && v < g.V();
		}
	}

	static class Graph {
		private final List<Integer>[] adj;
		private final int V;
		private int E;

		@SuppressWarnings("unchecked")
		public Graph(final int V) {
			this.V = V;
			adj = new List[V];
			for (int i = 0; i < adj.length; i++)
				adj[i] = new ArrayList<>();
		}

		@SuppressWarnings("unchecked")
		public Graph(final int[] from, final int[] to, final int V) {
			assert from != null;
			assert to != null;
			this.V = V;
			adj = new List[V];
			for (int i = 0; i < adj.length; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < from.length; i++) {
				add(from[i], to[i]);
			}
		}

		public void add(final int v, final int u) {
			validate(v);
			validate(u);
			adj[v].add(u);
			E++;
		}

		public Iterable<Integer> adj(final int v) {
			validate(v);
			return adj[v];
		}

		public int V() {
			return V;
		}

		public int E() {
			return E;
		}

		private void validate(final int v) {
			assert 0 <= v && v < adj.length;
		}

	}

	static class LCA {
		private final TreeLifting tl;

		public LCA(final int[][] adj, final int root) {
			tl = new TreeLifting(adj, root);
		}

		public LCA(final TreeLifting tl) {
			this.tl = tl;
		}

		public int get(int farthest, int closest) {
			if (tl.level(farthest) < tl.level(closest)) {
				int swap = farthest;
				farthest = closest;
				closest = swap;
			}
			for (int diff = tl.level(farthest) - tl.level(closest); diff > 0;) {
				int highest = Integer.highestOneBit(diff);
				int leap = Integer.numberOfTrailingZeros(highest);
				farthest = tl.parent(farthest, leap);
				diff ^= highest;
			}
			if (farthest == closest)
				return farthest;
			for (int i = tl.log(); i >= 0; i--) {
				if (tl.parent(farthest, i) != tl.parent(closest, i)) {
					farthest = tl.parent(farthest, i);
					closest = tl.parent(closest, i);
				}
			}
			return tl.parent(farthest, 0);
		}
	}
}
