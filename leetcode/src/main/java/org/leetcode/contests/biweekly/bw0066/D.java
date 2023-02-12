package org.leetcode.contests.biweekly.bw0066;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int countPyramids(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int ans = 0;
		ans += count(grid);
		grid = rotateByX(grid);
		ans += count(grid);
		return ans;
	}

	int count(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int[][] dp = new int[n][m];
		int INF = Integer.MAX_VALUE;
		int ans = 0;
		for (int[] row : dp)
			Arrays.fill(row, INF);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (grid[i][j] == 1)
					dp[i][j] = 0;
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 1; j < m - 1; j++) {
				if (dp[i][j] == INF)
					continue;
				if (dp[i + 1][j - 1] != INF && dp[i + 1][j] != INF && dp[i + 1][j + 1] != INF) {
					int min = Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
					dp[i][j] = min + 1;
					ans += dp[i][j];
				}
			}
		}
		return ans;
	}

	int[][] rotateByX(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int[][] ret = new int[n][m];
		for (int i = 0; i < n; i++) {
			ret[i] = Arrays.copyOf(grid[n - i - 1], grid[n - i - 1].length);
		}
		return ret;
	}
}
