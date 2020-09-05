package org.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001568_MinimumNumberOfDaysToDisconnectIsland {
	// [[1,1,0,1,1], [1,1,1,1,1], [1,1,0,1,1], [1,1,1,1,1]] -> 2
	static int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int minDays(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int lands = 0;

		for (int r = 0, id = 1; r < n; r++)
			for (int c = 0; c < m; c++)
				if (grid[r][c] == 1) {
					lands++;
					grid[r][c] = id++;
				}

		if (check(grid, 0, lands) > 1)
			return 0;
		for (int i = 1; i <= lands; i++) {
			if (check(grid, i, lands) - 1 > 1)
				return 1;
		}
		return 2;

	}

	int check(int[][] grid, int excluded, int size) {
		int n = grid.length;
		int m = grid[0].length;
		WeightedQuickUnion dsu = new WeightedQuickUnion(size);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (grid[r][c] == excluded || grid[r][c] == 0)
					continue;
				for (int[] nei : adj(r, c, grid)) {
					int nr = nei[0];
					int nc = nei[1];
					if (grid[nr][nc] == excluded)
						continue;
					dsu.union(grid[r][c] - 1, grid[nr][nc] - 1);
				}
			}
		}
		return dsu.componentCount();
	}

	ArrayList<int[]> adj(int r, int c, int[][] grid) {
		assert r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] > 0;
		ArrayList<int[]> ret = new ArrayList<>(4);
		for (int[] d : d4) {
			int nr = r + d[0];
			int nc = c + d[1];
			if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] > 0)
				ret.add(new int[] { nr, nc });
		}
		return ret;
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
