package org.leetcode.contests.weekly.w0211;

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
public class _001627_GraphConnectivityWithThreshold {
	public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
		List<Boolean> ans = new ArrayList<>();
		WeightedQuickUnion dsu = new WeightedQuickUnion(n + 1);
		for (int i = threshold + 1; i <= n / 2; i++) {
			int j = i;
			while (j <= n) {
				dsu.union(i, j);
				j += i;
			}
		}
		for (int[] q : queries) {
			ans.add(dsu.connected(q[0], q[1]));
		}
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
