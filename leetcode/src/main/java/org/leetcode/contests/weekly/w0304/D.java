package org.leetcode.contests.weekly.w0304;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int longestCycle(int[] edges) {
		int n = edges.length;
		int m = 0;
		for (int e : edges) {
			if (e != -1)
				m++;
		}
		int[] from = new int[m];
		int[] to = new int[m];
		for (int i = 0, p = 0; i < n; i++) {
			if (edges[i] != -1) {
				from[p] = i;
				to[p] = edges[i];
				p++;
			}
		}
		int[][] adj = packD(n, from, to);
		TarjanSCC scc = new TarjanSCC(adj);
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int x : scc.id) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		for (int cand : map.values()) {
			ans = Math.max(ans, cand);
		}
		return ans < 2 ? -1 : ans;
	}

	static int[][] packD(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++)
			out[from[i]]++;
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++)
			ret[from[i]][--out[from[i]]] = to[i];
		return ret;
	}

	static class TarjanSCC {
		private final boolean[] visited;
		private final int[] id;
		private final int[] preorder;
		private int preorderCounter;
		private int componentCounter;
		private final Stack<Integer> stack;

		public TarjanSCC(final int[][] adj) {
			final int n = adj.length;
			visited = new boolean[n];
			id = new int[n];
			preorder = new int[n];
			stack = new Stack<>();
			for (int i = 0; i < n; i++) {
				if (visited[i])
					continue;
				dfs(i, adj);
			}
		}

		private void dfs(int cur, int[][] adj) {
			visited[cur] = true;
			stack.push(cur);
			preorder[cur] = preorderCounter++;
			int minPreorder = preorder[cur];
			for (int next : adj[cur]) {
				if (!visited[next]) {
					dfs(next, adj);
				}
				minPreorder = Math.min(minPreorder, preorder[next]);
			}
			if (minPreorder < preorder[cur]) {
				preorder[cur] = minPreorder;
				return;
			}
			int v;
			do {
				v = stack.pop();
				id[v] = componentCounter;
				preorder[v] = adj.length;
			} while (v != cur);
			componentCounter++;
		}

		public int id(final int v) {
			Objects.checkIndex(v, id.length);
			return id[v];
		}

		public boolean stronglyConnected(final int v, final int w) {
			Objects.checkIndex(v, id.length);
			Objects.checkIndex(w, id.length);
			return id[v] == id[w];
		}

	}

}
