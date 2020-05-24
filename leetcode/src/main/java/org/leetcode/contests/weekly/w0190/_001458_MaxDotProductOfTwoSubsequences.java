package org.leetcode.contests.weekly.w0190;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001458_MaxDotProductOfTwoSubsequences {
	public int maxDotProduct(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MIN_VALUE / 2);
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				int ignoreCur = Math.max(dp[r][c], Math.max(dp[r + 1][c], dp[r][c + 1]));
				dp[r + 1][c + 1] = Math.max(ignoreCur,
						            Math.max(dp[r][c] + nums1[r] * nums2[c], nums1[r] * nums2[c]));
			}
		}
		return dp[n][m];
	}
}
