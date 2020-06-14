package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000547_FriendCircles {
	public int findCircleNum(int[][] M) {
		int n = M.length;
		WQU wqu = new WQU(n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1) {
					wqu.union(i, j);
				}
			}
		}
		return wqu.numberOfComponents();
	}

	static class WQU {
		private final int[] id;
		private final int[] sz;
		private int numberOfComponents;

		public WQU(int n) {
			id = new int[n];
			for (int i = 0; i < n; i++)
				id[i] = i;

			sz = new int[n];
			for (int i = 0; i < n; i++)
				sz[i] = 1;

			numberOfComponents = n;
		}

		public int find(int v) {
			validate(v);
			while (id[v] != v) {
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

			numberOfComponents--;
		}

		public int size(int v) {
			validate(v);
			return sz[v];
		}

		private void validate(int v) {
			if (v < 0 || v >= id.length) {
				throw new IllegalArgumentException(
						"v: " + v + " should be between 0 and " + (id.length - 1));
			}
		}

		public int numberOfComponents() {
			return numberOfComponents;
		}
	}
}
