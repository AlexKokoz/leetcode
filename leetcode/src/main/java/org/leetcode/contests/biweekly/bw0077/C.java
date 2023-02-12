package org.leetcode.contests.biweekly.bw0077;

import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	@SuppressWarnings("unchecked")
	public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
		long[][] gridr = new long[n + 1][m + 1];
		long[][] gridc = new long[n + 1][m + 1];
		boolean[][] blocked = new boolean[n][m];
		TreeSet<Integer>[] rows = new TreeSet[n];
		for (int i = 0; i < n; i++) {
			rows[i] = new TreeSet<>();
			rows[i].add(-1);
			rows[i].add(m);
		}
		TreeSet<Integer>[] cols = new TreeSet[m];
		for (int i = 0; i < m; i++) {
			cols[i] = new TreeSet<>();
			cols[i].add(-1);
			cols[i].add(n);
		}
		for (int[] wall : walls) {
			rows[wall[0]].add(wall[1]);
			cols[wall[1]].add(wall[0]);
			blocked[wall[0]][wall[1]] = true;
		}
		for (int[] g : guards) {
			int r = g[0], c = g[1];
			blocked[r][c] = true;
			int left = rows[r].lower(c) + 1;
			int right = rows[r].higher(c);
			gridr[r][left]++;
			gridr[r][right]--;

			int top = cols[c].lower(r) + 1;
			int bottom = cols[c].higher(r);
			gridc[top][c]++;
			gridc[bottom][c]--;

		}

		for (int r = 0; r < n; r++) {
			for (int c = 1; c < m; c++) {
				gridr[r][c] += gridr[r][c - 1];
			}
		}
		for (int c = 0; c < m; c++) {
			for (int r = 1; r < n; r++) {
				gridc[r][c] += gridc[r - 1][c];
			}
		}
		int ans = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (!blocked[r][c] && gridr[r][c] == 0 && gridc[r][c] == 0)
					ans++;
			}
		}
		return ans;

	}
}
