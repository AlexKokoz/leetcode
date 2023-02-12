package org.leetcode.contests.weekly.w0305;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public boolean validPartition(int[] nums) {
		int n = nums.length;
		boolean[][] dp = new boolean[3][n + 1];
		dp[0][0] = dp[1][0] = dp[2][0] = true;
		for (int i = 0; i < n; i++) {
			if (i >= 1) {
				dp[0][i + 1] = nums[i] == nums[i - 1] && (dp[0][i - 1] || dp[1][i - 1] || dp[2][i - 1]);
			}
			if (i >= 2) {
				dp[1][i + 1] = nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]
						&& (dp[0][i - 2] || dp[1][i - 2] || dp[2][i - 2]);
				dp[2][i + 1] = nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1
						&& (dp[0][i - 2] || dp[1][i - 2] || dp[2][i - 2]);
			}

		}
		return dp[0][n] || dp[1][n] || dp[2][n];
	}
}
