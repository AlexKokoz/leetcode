package org.leetcode.contests.weekly.w0205;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		int ans = 0;
		int p = edges.length;

		WeightedQuickUnion dsu1 = new WeightedQuickUnion(n);
		for (int[] edge : edges) {
			if (edge[0] == 3) {
				int v = edge[1] - 1;
				int w = edge[2] - 1;
				dsu1.union(v, w);
			}
		}
		if (dsu1.componentCount() == 1)
			return p - n + 1;

		WeightedQuickUnion dsu2 = new WeightedQuickUnion(n);
		for (int[] edge : edges) {
			if (edge[0] == 3) {
				int v = edge[1] - 1;
				int w = edge[2] - 1;
				dsu2.union(v, w);
			}
		}

		int t3 = 0;
		for (int i = 0; i < dsu1.id.length; i++) {
			if (dsu1.id[i] == i)
				t3 += dsu1.sz[i] - 1;
		}

		for (int[] edge : edges) {
			if (edge[0] == 1) {
				int v = edge[1] - 1;
				int w = edge[2] - 1;
				dsu1.union(v, w);
			}
		}
		if (dsu1.componentCount() != 1)
			return -1;

		for (int[] edge : edges) {
			if (edge[0] == 2) {
				int v = edge[1] - 1;
				int w = edge[2] - 1;
				dsu2.union(v, w);
			}
		}

		if (dsu2.componentCount() != 1)
			return -1;

		int t1 = n - 1 - t3;
		int t2 = n - 1 - t3;
		ans = p - (t1 + t2 + t3);
		return ans;
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
