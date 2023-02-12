package org.leetcode.contests.weekly.w0298;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minimumNumbers(int sum, int d) {
		if (sum == 0)
			return 0;
		List<Integer> nums = new ArrayList<>();
		int num = d;
		while (num <= sum) {
			nums.add(num);
			num += 10;
		}
		int[] dp = new int[sum + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i <= sum; i++) {
			for (int x : nums) {
				if (i - x < 0) {
					break;
				}
				if (dp[i - x] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - x] + 1);
				}
			}
		}
		return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
	}
}
