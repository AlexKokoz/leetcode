package org.leetcode.contests.weekly.w0221;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001706_WhereWillTheBallFall {
	public int[] findBall(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		WeightedQuickUnion dsu = new WeightedQuickUnion(n * m + m);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				// to right
				if (grid[r][c] == 1 && c + 1 < m && grid[r][c + 1] == 1) {
					int v = flatten(r, c, m);
					int w = flatten(r + 1, c + 1, m);
					dsu.union(v, w);
				}
				// to left
				else if (grid[r][c] == -1 && c - 1 >= 0 && grid[r][c - 1] == -1) {
					int v = flatten(r, c, m);
					int w = flatten(r + 1, c - 1, m);
					dsu.union(v, w);
				}
			}
		}
		Map<Integer, Integer> id2col = new HashMap<>();
		for (int c = 0; c < m; c++) {
			id2col.put(dsu.find(n * m + c), c);
		}
		int[] ans = new int[m];
		for (int c = 0; c < m; c++) {
			ans[c] = id2col.getOrDefault(dsu.find(c), -1);
		}
		return ans;
	}

	static int flatten(int r, int c, int C) {
		return r * C + c;
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
