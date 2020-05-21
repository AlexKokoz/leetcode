package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000765_CouplesHoldingHands {
	public int minSwapsCouples(int[] row) {
		int n = row.length;
		int couples = n / 2;
		WeightedQuickUnionFind qu = new WeightedQuickUnionFind(couples);
		for (int i = 0; i < n; i += 2) {
			int couple1 = row[i] / 2;
			int couple2 = row[i + 1] / 2;
			if (couple1 != couple2) {
				qu.union(couple1, couple2);
			}
		}

		return couples - qu.comps();
	}

	static class WeightedQuickUnionFind {
		int[] id;
		int[] sz;
		int comps;

		public WeightedQuickUnionFind(int n) {
			id = new int[n];
			for (int i = 0; i < n; i++)
				id[i] = i;

			sz = new int[n];
			Arrays.fill(sz, 1);

			comps = n;
		}

		public int comps() {
			return comps;
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
			comps--;
		}

		private void validate(int v) {
			if (v < 0 || v >= id.length) {
				throw new IllegalArgumentException("v should be between 0 and " + (id.length - 1));
			}
		}
	}
}
