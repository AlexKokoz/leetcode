package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000741_CherryPickup {
	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dirs = { { 1, 0 }, { 0, 1 } };

		int[][][][] dp = new int[n][m][n][m];
		for (int[][][] row3 : dp)
			for (int[][] row2 : row3)
				for (int[] row : row2)
					Arrays.fill(row, -1);
		dp[0][0][0][0] = grid[0][0];
		int ndiag = n + m - 1;
		for (int d = 0; d < ndiag; d++) {
			Iterable<int[]> curDiag = diag(d, n, m);
			for (int[] cell1 : curDiag) {
				int r1 = cell1[0], c1 = cell1[1];
				for (int[] cell2 : curDiag) {
					int r2 = cell2[0], c2 = cell2[1];
					if (dp[r1][c1][r2][c2] < 0)
						continue;
					for (int[] dir1 : dirs) {
						int nr1 = r1 + dir1[0], nc1 = c1 + dir1[1];
						if (nr1 == n || nc1 == m || grid[nr1][nc1] == -1)
							continue;
						for (int[] dir2 : dirs) {
							int nr2 = r2 + dir2[0], nc2 = c2 + dir2[1];
							if (nr2 == n || nc2 == m || grid[nr2][nc2] == -1)
								continue;

							int cand = dp[r1][c1][r2][c2] + grid[nr1][nc1] + grid[nr2][nc2];
							if (nr1 == nr2 && nc1 == nc2) {
								cand -= grid[nr1][nc1];
							}

							dp[nr1][nc1][nr2][nc2] = Math.max(dp[nr1][nc1][nr2][nc2], cand);
						}
					}
				}
			}
		}

		return dp[n - 1][m - 1][n - 1][m - 1] == -1 ? 0 : dp[n - 1][m - 1][n - 1][m - 1];
	}

	Iterable<int[]> diag(int d, int n, int m) {
		Queue<int[]> q = new LinkedList<>();
		int r, c;
		if (d < n) {
			r = d;
			c = 0;
		} else {
			r = n - 1;
			c = d - n + 1;
		}
		while (r >= 0 && c < m) {
			q.add(new int[] { r, c });
			r--;
			c++;
		}
		return q;
	}
}
