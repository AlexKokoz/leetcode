package org.leetcode.contests.weekly.w0329;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int minCost(int[] nums, int k) {
		int n = nums.length;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int l = 0; l < n; l++) {
			Map<Integer, Integer> counts = new HashMap<>();
			int importance = k;
			for (int r = l; r < n; r++) {
				int count = counts.getOrDefault(nums[r], 0) + 1;
				counts.put(nums[r], count);
				if (count == 2) {
					importance += 2;
				} else if (count > 2) {
					importance++;
				}
				dp[r + 1] = Math.min(dp[r + 1], dp[l] + importance);
			}
		}
		return dp[n];
	}
}
