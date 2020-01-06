package org.leetcode.contests.biweekly.bw0015;

import java.util.Arrays;

/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001289_MinimumFallingPathSumII {

	public int minFallingPathSum(int[][] arr) {
		final int R = arr.length;
		final int C = arr[0].length;

		final int[][] dp = new int[R][C];

		for (int c = 0; c < C; c++)
			dp[0][c] = arr[0][c];
		for (int r = 1; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int min = Integer.MAX_VALUE;
				for (int nc = 0; nc < C; nc++) {
					if (nc == c)
						continue;
					min = Math.min(min, dp[r - 1][nc]);
				}
				dp[r][c] = arr[r][c] + min;
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int c = 0; c < C; c++) {
			ans = Math.min(ans, dp[R - 1][c]);
		}
		System.out.println(Arrays.deepToString(dp));
		return ans;
	}

}
