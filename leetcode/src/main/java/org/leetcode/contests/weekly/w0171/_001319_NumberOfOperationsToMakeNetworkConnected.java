package org.leetcode.contests.weekly.w0171;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001319_NumberOfOperationsToMakeNetworkConnected {
	int[] id;
	int count;

	public int makeConnected(int n, int[][] connections) {
		int nc = connections.length;
		if (nc < n - 1)
			return -1;
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
		count = n;
		for (int[] con : connections) {
			union(con[0], con[1]);
		}
		return count - 1;
	}

	void union(int v, int w) {
		int p = find(v);
		int q = find(w);
		if (p == q)
			return;
		count--;
		id[q] = p;
	}

	int find(int v) {
		while (v != id[v]) {
			id[v] = id[id[v]];
			v = id[v];
		}
		return v;
	}

	boolean connected(int v, int w) {
		return find(v) == find(w);
	}
}
