package org.leetcode.contests.biweekly.bw0069;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
		int n = grid.length, m = grid[0].length;
		int[][] cum = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cum[i + 1][j + 1] = grid[i][j] + cum[i][j + 1] + cum[i + 1][j] - cum[i][j];
			}
		}

		int[][] grid2 = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1)
					continue;
				int ii = i - stampHeight + 1;
				int jj = j - stampWidth + 1;
				if (ii < 0 || jj < 0)
					continue;
				int sum = cum[i + 1][j + 1] - cum[ii][j + 1] - cum[i + 1][jj] + cum[ii][jj];
				if (sum == 0) {
					grid2[ii][jj]++; // top-left
					grid2[ii][j + 1]--; // after bottom-left
					grid2[i + 1][jj]--; // after top-right
					grid2[i + 1][j + 1]++; // diagonally after bottom-right
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int up = i == 0 ? 0 : grid2[i - 1][j];
				int left = j == 0 ? 0 : grid2[i][j - 1];
				int diag = (i == 0 || j == 0) ? 0 : grid2[i - 1][j - 1];
				grid2[i][j] += up + left - diag;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1)
					continue;
				if (grid2[i][j] == 0)
					return false;
			}
		}
		return true;
	}

}
