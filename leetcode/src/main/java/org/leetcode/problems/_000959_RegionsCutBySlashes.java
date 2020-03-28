package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000959_RegionsCutBySlashes {

	// each grid divided into 4 triangles: 0,1,2,3 from top, clockwise
	public int regionsBySlashes(String[] grid) {
		int n = grid.length;
		QuickUnion qu = new QuickUnion(4 * n * n);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				char ch = grid[r].charAt(c);
				int base = flatten(r, c, n) * 4;
				if (ch == '/') {
					qu.union(base, base + 3);
					qu.union(base + 1, base + 2);
				} else if (ch == '\\') {
					qu.union(base, base + 1);
					qu.union(base + 2, base + 3);
				} else {
					qu.union(base, base + 1);
					qu.union(base + 1, base + 2);
					qu.union(base + 2, base + 3);
				}
				// top
				if (r > 0) {
					int nbase = 4 * flatten(r - 1, c, n);
					qu.union(base, nbase + 2);
				}
				// right
				if (c < n - 1) {
					int nbase = 4 * flatten(r, c + 1, n);
					qu.union(base + 1, nbase + 3);
				}
				// bottom
				if (r < n - 1) {
					int nbase = 4 * flatten(r + 1, c, n);
					qu.union(base + 2, nbase);
				}
				// left
				if (c > 0) {
					int nbase = 4 * flatten(r, c - 1, n);
					qu.union(base + 3, nbase + 1);
				}
			}
		}
		return qu.componentCount();
	}

	int flatten(int r, int c, int C) {
		return r * C + c;
	}

	static class QuickUnion {

		private final int[] id;
		private final int[] size;
		private int componentCount;

		public QuickUnion(int n) {
			componentCount = n;
			id = new int[n];
			size = new int[n];
			for (int i = 0; i < size.length; i++) {
				id[i] = i;
				size[i] = 1;
			}
		}

		public boolean connected(int i, int j) {
			return find(i) == find(j);
		}

		public void union(int i, int j) {
			validate(i);
			validate(j);
			final int p = find(i);
			final int q = find(j);
			if (p == q)
				return;
			componentCount--;
			if (size[p] > size[q]) {
				id[q] = p;
				size[p] += size[q];
			} else {
				id[p] = q;
				size[q] += size[p];
			}

		}

		public int componentCount() {
			return componentCount;
		}

		public int find(int i) {
			validate(i);
			while (id[i] != i) {
				id[i] = id[id[i]];
				i = id[id[i]];
			}
			return i;
		}

		private void validate(int i) {
			final int n = id.length;
			if (i < 0 || i >= n)
				throw new IllegalArgumentException("p: " + i + " is not between 0 and " + (n - 1));
		}
	}
}
