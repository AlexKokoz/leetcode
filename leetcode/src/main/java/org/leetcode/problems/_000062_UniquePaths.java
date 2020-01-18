package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000062_UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[n][m];
		for (int c = 0; c < m; c++)
			dp[0][c] = 1;
		for (int r = 0; r < n; r++)
			dp[r][0] = 1;
		for (int r = 1; r < n; r++) {
			for (int c = 1; c < m; c++) {
				dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
			} 
		}
		return dp[n-1][m-1];
	}
}
