package org.leetcode.contests.biweekly.bw0039;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001655_DistributeRepeatingIntegers {
	Boolean[][] dp;
	int[] quantity;
	int[] nums;

	public boolean canDistribute(int[] nums, int[] quantity) {
		int nWant = quantity.length;
		this.quantity = quantity;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		this.nums = new int[map.size()];
		this.dp = new Boolean[map.size()][1 << nWant];
		int nHave = 0;
		for (int num : map.values())
			this.nums[nHave++] = num;

		return dp(0, (1 << nWant) - 1);
	}

	boolean dp(int i, int rem) {
		if (rem == 0)
			return true;
		if (i == nums.length)
			return false;
		if (dp[i][rem] != null)
			return dp[i][rem];
		int have = nums[i];
		int submask = rem;
		while (submask > 0) {
			int want = 0;
			for (int k = 0; k < quantity.length; k++)
				if (submask << ~k < 0)
					want += quantity[k];
			if (want <= have) {
				if (dp(i + 1, rem ^ submask)) {
					dp[i][rem] = true;
					return dp[i][rem];
				}
			}
			submask = (submask - 1) & rem;
		}
		dp[i][rem] = dp(i + 1, rem);
		return dp[i][rem];

	}
}
