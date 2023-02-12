package org.leetcode.contests.biweekly.bw0097;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	int time = 0;
	boolean foundArticulation = false;

	public boolean isPossibleToCutPath(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		DSU dsu = new DSU(n * m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					if (i + 1 < n && grid[i + 1][j] == 1) {
						dsu.union(i * m + j, (i + 1) * m + j);
					}
					if (j + 1 < m && grid[i][j + 1] == 1) {
						dsu.union(i * m + j, i * m + (j + 1));
					}
				}
			}
		}
		if (!dsu.connected(0, n * m - 1)) {
			return true;
		}
		Graph g = new Graph(n * m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					if (i + 1 < n && grid[i + 1][j] == 1) {
						g.add(i * m + j, (i + 1) * m + j);
					}
					if (j + 1 < m && grid[i][j + 1] == 1) {
						g.add(i * m + j, i * m + (j + 1));
					}
				}
			}
		}
		// System.out.println(g);

		boolean[] visited = new boolean[g.V()];
		int[] disc = new int[g.V()];
		int[] low = new int[g.V()];
		boolean[] isAP = new boolean[g.V()];

		dfs(-1, 0, g, visited, disc, low, isAP);

		return foundArticulation;
	}

	void dfs(int par, int cur, Graph g, boolean[] visited, int[] disc, int[] low, boolean[] isAp) {
		if (foundArticulation)
			return;
		visited[cur] = true;
		disc[cur] = low[cur] = ++time;
		for (int next : g.adj(cur)) {
			if (!visited[next]) {
				dfs(cur, next, g, visited, disc, low, isAp);
				if (foundArticulation)
					return;
				low[cur] = Math.min(low[cur], low[next]);
				if (cur != 0 && cur != g.V() - 1 && low[next] >= disc[cur]) {
					foundArticulation = true;
					return;
				}
			} else if (next != par) {
				low[cur] = Math.min(low[cur], disc[next]);
			}
		}
	}

	class Graph {
		private final List<Integer>[] adj;
		private final int V;
		private int E;

		@SuppressWarnings("unchecked")
		public Graph(final int V) {
			this.V = V;
			adj = new List[V];
			for (int i = 0; i < adj.length; i++)
				adj[i] = new LinkedList<>();
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
			adj[u].add(v);
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

		public int degree(int v) {
			validate(v);
			return adj[v].size();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Graph V = ").append(V()).append(" E = ").append(E()).append("\n");
			for (int v = 0; v < V(); v++) {
				sb.append("  ").append(v).append(": ")
						.append(StreamSupport.stream(adj(v).spliterator(), false)
								.map(x -> Integer.toString(x))
								.collect(Collectors.joining(",")))
						.append("\n");

			}
			return sb.toString();
		}

		private void validate(final int v) {
			assert 0 <= v && v < adj.length;
		}

	}

	class DSU {
		int[] id;
		int[] sz;
		int componentCount;

		public DSU(int n) {
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
