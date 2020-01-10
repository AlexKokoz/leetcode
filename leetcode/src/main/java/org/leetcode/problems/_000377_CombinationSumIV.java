package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000377_CombinationSumIV {

	/*
	 * The intuition is the similar to the Coin Change(#322) problem.
	 * 
	 * The dp array denotes the possible sum values up to and including target.
	 * 
	 * First the sums corresponding to the given numbers are initialized with 1(this
	 * denotes a combination of length 1; the number itself, selected once).
	 * 
	 * Then for each possible sum, starting from 0 to target, we loop the given
	 * numbers and check if we can reach sum from: sum - num(num being the current
	 * given number).
	 * 
	 * If sum - num i a valid (nonnegative) value its combination
	 * count is added to sum's. Thus the combination count for each possible sum is
	 * built bottom up, up to the final result which is dp[target];
	 * 
	 * 
	 */
	public int combinationSum4(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		for (int num : nums)
			min = Math.min(min, num);
		if (target < min)
			return 0;
		int[] dp = new int[target + 1];
		for (int num : nums)
			if (num <= target)
				dp[num]++;
		for (int sum = 0; sum <= target; sum++) {
			for (int num : nums) {
				if (sum - num >= 0) {
					dp[sum] += dp[sum - num];
				}
			}
		}
		return dp[target];
	}
}
