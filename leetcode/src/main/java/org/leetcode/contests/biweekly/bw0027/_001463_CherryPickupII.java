package org.leetcode.contests.biweekly.bw0027;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001463_CherryPickupII {
	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] dc = new int[] { -1, 0, 1 };

		int[][] dp = new int[m][m];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		dp[0][m - 1] = grid[0][0] + grid[0][m - 1];
		for (int r = 1; r < n; r++) {
			int[][] ndp = new int[m][m];
			for (int[] row : ndp)
				Arrays.fill(row, -1);
			for (int c1 = 0; c1 < m; c1++) {
				for (int c2 = 0; c2 < m; c2++) {
					if (dp[c1][c2] < 0)
						continue;
					for (int dc1 : dc) {
						int nc1 = c1 + dc1;
						if (nc1 < 0 || nc1 >= m)
							continue;
						for (int dc2 : dc) {
							int nc2 = c2 + dc2;
							if (nc2 < 0 || nc2 >= m)
								continue;
							int cand = dp[c1][c2];
							if (nc1 != nc2) {
								cand += grid[r][nc1] + grid[r][nc2]; // robots in
													// different
													// cells (in the
													// same row)
							} else {
								cand += grid[r][nc1]; // both robots in same cell;
							}
							ndp[nc1][nc2] = Math.max(ndp[nc1][nc2], cand);
						}
					}
				}
			}

			dp = ndp;
		}

		int ans = 0;
		for (int[] row : dp) {
			for (int x : row) {
				ans = Math.max(ans, x);
			}
		}
		return ans;
	}
}
