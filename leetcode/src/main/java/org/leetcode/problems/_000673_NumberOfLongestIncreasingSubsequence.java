package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000673_NumberOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int[] count = new int[n];
		Arrays.fill(count, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (dp[j] >= dp[i]) {
						count[i] = count[j];
						dp[i] = dp[j] + 1;
					} else if (dp[i] == dp[j] + 1) {
						count[i] += count[j];
					}
				}
			}
		}
		int max = 0;
		int ans = 0;
		for (int len : dp)
			max = Math.max(max, len);
		for (int i = 0; i < n; i++)
			if (dp[i] == max)
				ans += count[i];
		return ans;
	}
}
