package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000684_RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		int[] id = new int[edges.length + 1];
		for (int i = 1; i < id.length; i++)
			id[i] = i;
		for (int[] edge : edges) {
			int v = edge[0];
			int w = edge[1];
			int p = find(v, id);
			int q = find(w, id);
			if (p == q) return edge;
			id[p] = q;
		}
		return new int[2];
	}

	int find(int v, int[] id) {
		while (id[v] != v)
			v = id[v];
		return v;
	}
}
