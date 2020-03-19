package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001254_NumbeOfClosedIslands {
	public int closedIsland(int[][] grid) {
//		final int LAND = 0;
		final int WATER = 1;
		int nr = grid.length;
		if (nr == 0)
			return 0;
		int nc = grid[0].length;
		int size = nr * nc;
		QuickUnion qu = new QuickUnion(size + 1); // + 1 is the dummy node for thegrid border

		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				int id = flatten(r, c, nc);
				// connect all edge cells to the border node
				if (r == 0 || c == 0 || r == nr - 1 || c == nc - 1) {
					qu.union(id, size);
					continue;
				}
				// connect all water cells to the border node
				if (grid[r][c] == WATER) {
					qu.union(id, size);
					continue;
				}
				for (int dr = -1; dr <= 1; dr++) {
					for (int dc = -1; dc <= 1; dc++) {
						if (dr == 0 ^ dc == 0) { // don't consider diagonal cells
							if (grid[r + dr][c + dc] != grid[r][c])
								continue; // don't consider adjacent water cells
							int nei = flatten(r + dr, c + dc, nc); // neighbor id
							qu.union(id, nei);
						}
					}
				}
			}
		}
		return qu.componentCount() - 1; // 1 of the components is the border
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
