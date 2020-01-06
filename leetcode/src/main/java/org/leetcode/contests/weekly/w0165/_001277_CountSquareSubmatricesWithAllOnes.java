package org.leetcode.contests.weekly.w0165;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001277_CountSquareSubmatricesWithAllOnes {

	public int countSquares(int[][] matrix) {
		final int R = matrix.length;
		final int C = matrix[0].length;
		int ans = 0;
		final int[][] dp = new int[R + 1][C + 1];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (matrix[r][c] == 1)
					dp[r + 1][c + 1] = matrix[r][c] + Math.min(dp[r][c], Math.min(dp[r][c + 1], dp[r + 1][c]));
				ans += dp[r + 1][c + 1];
			}
		}
		return ans;
	}
}
