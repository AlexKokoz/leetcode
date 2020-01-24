package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000198_HouseRobber {
	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int[][] dp = new int[n][2]; // 2 options for each house: 0(ignore), 1(use)
		dp[0][1] = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
		}
		return Math.max(dp[n - 1][0], dp[n - 2][1]);
	}
}
