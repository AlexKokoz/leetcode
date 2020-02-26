package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000685_RedundantConnectionII {
	@SuppressWarnings("unchecked")
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;

		// adjacency list
		List<Integer>[] adj = new List[n + 1];
		for (int i = 1; i <= n; i++)
			adj[i] = new LinkedList<>();

		// in-degree for each vertex
		int[] indeg = new int[n + 1];

		// union-find
		int[] id = new int[n + 1];
		for (int i = 1; i <= n; i++)
			id[i] = i;

		int[] ans = new int[2];
		for (int[] edge : edges) {
			int v = edge[0];
			int w = edge[1];
			adj[v].add(w); 
			if (adj[v].size() == 3) return new int[] {v, w};
			indeg[w]++;
			int p = find(v, id);
			int q = find(w, id);
			if (p == q)
				ans = new int[] { v, w };
			id[p] = q;
		}

		int root = 0;
		for (int i = 1; i < n; i++)
			if (indeg[i] == 0) {
				root = i;
				break;
			}
		if (root != 0) { // cycle doesn't include the root
			for (int i = n - 1; i >= 0; i--) {
				int v = edges[i][0];
				int w = edges[i][1];
				if (indeg[w] == 2) {
					if (adj[w].size() == 0) {
						return new int[] { v, w };
					}
					break;
				}
			}
			boolean[] marked = new boolean[n + 1];
			return findRedundantEdge(root, adj, marked);
		}
		return ans;
	}

	int find(int v, int[] id) {
		while (id[v] != v)
			v = id[v];
		return v;
	}

	int[] findRedundantEdge(int root, List<Integer>[] adj, boolean[] marked) {
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		marked[root] = true;
		while (true) {
			int v = q.poll();
			for (int w : adj[v]) {
				if (marked[w]) {
					return new int[] { v, w };
				} else {
					q.add(w);
					marked[w] = true;
				}
			}
		}
	}
}
