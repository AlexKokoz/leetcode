package org.leetcode.contests.weekly.w0210;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001617_CountSubtreesWithMaxDistanceBetweenCities {
	public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {

		int[] ans = new int[n - 1];
		Set<Integer> seen = new HashSet<>();

		for (int[] e : edges) {
			e[0]--;
			e[1]--;
		}

		for (int sub = 1; sub < 1 << n; sub++) {

			@SuppressWarnings("unchecked")
			List<Integer>[] adj = new List[n];
			WeightedQuickUnion dsu = new WeightedQuickUnion(n);
			boolean[] active = new boolean[n];
			int current = 0;
			int src = -1;
			int[] best = new int[1];
			int[] bestVertex = new int[1];

			for (int i = 0; i < n; i++) {
				if (sub << ~i < 0) {
					active[i] = true;
					src = i;
				}
			}

			for (int[] e : edges) {
				if (active[e[0]] && active[e[1]]) {
					current |= (1 << e[0]) | (1 << e[1]);
					dsu.union(e[0], e[1]);
				}
			}
			
			if (current == 0 || seen.contains(current)
					|| dsu.componentCount() != n - Integer.bitCount(sub) + 1)
				continue;
			
			seen.add(current);
			
			for (int i = 0; i < n; i++)
				adj[i] = new LinkedList<>();
			for (int[] e : edges) {
				if (active[e[0]] && active[e[1]]) {
					adj[e[0]].add(e[1]);
					adj[e[1]].add(e[0]);
				}
			}
			
			dfs(-1, src, 0, adj, best, bestVertex);
			best = new int[1];
			src = bestVertex[0];
			bestVertex = new int[1];
			dfs(-1, src, 0, adj, best, bestVertex);
			ans[best[0] - 1]++;
		}
		return ans;
	}

	void dfs(int p, int ch, int d, List<Integer>[] adj, int[] best, int[] bestVertex) {
		if (d > best[0]) {
			best[0] = d;
			bestVertex[0] = ch;
		}
		for (int nch : adj[ch]) {
			if (nch == p)
				continue;
			dfs(ch, nch, d + 1, adj, best, bestVertex);
		}
	}

	class WeightedQuickUnion {
		int[] id;
		int[] sz;
		int componentCount;

		public WeightedQuickUnion(int n) {
			id = new int[n];
			for (int i = 0; i < n; i++)
				id[i] = i;
			sz = new int[n];
			Arrays.fill(sz, 1);
			componentCount = n;
		}

		public int componentCount() {
			return componentCount;
		}

		public int find(int v) {
			validate(v);
			while (v != id[v]) {
				id[v] = id[id[v]];
				v = id[v];
			}
			return v;
		}

		public boolean connected(int v, int w) {
			validate(v);
			validate(w);
			int p = find(v);
			int q = find(w);
			return p == q;
		}

		public void union(int v, int w) {
			validate(v);
			validate(w);
			int p = find(v);
			int q = find(w);
			if (p == q)
				return;
			if (sz[p] >= sz[q]) {
				id[q] = p;
				sz[p] += sz[q];
			} else {
				id[p] = q;
				sz[q] += sz[p];
			}
			componentCount--;
		}

		private void validate(int v) {
			if (v < 0 || v >= id.length) {
				throw new IllegalArgumentException("v should be between 0 and " + (id.length - 1));
			}
		}
	}
}
