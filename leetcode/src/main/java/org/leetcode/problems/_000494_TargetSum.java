package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000494_TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (S < -sum || S > sum)
			return 0;
		int[] dp = new int[(sum + 1) * 2];
		dp[sum + nums[0]]++;
		dp[sum - nums[0]]++;
		for (int i = 1; i < nums.length; i++) {
			int[] ndp = new int[(sum + 1) * 2];
			for (int j = 0; j < ndp.length; j++) {
				if (dp[j] == 0)
					continue;
				ndp[j + nums[i]] += dp[j];
				ndp[j - nums[i]] += dp[j];
			}
			dp = ndp;
		}
		return dp[S + sum];
	}
}
