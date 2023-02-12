package org.leetcode.contests.weekly.w0280;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int maximumANDSum(int[] nums, int numSlots) {
		int[] dp = new int[1 << 2 * numSlots];
		for (int mask = 1; mask < 1 << 2 * numSlots; mask++) {
			int u = mask >>> numSlots;
			int l = mask & ((1 << numSlots) - 1);
			if ((u & l) != u)
				continue;
			int num = Integer.bitCount(mask) - 1 < nums.length ? nums[Integer.bitCount(mask) - 1] : 0;
			for (int b = 0; b < numSlots; b++) {
				if (l << ~b < 0) {
					int bef = mask;
					if (u << ~b < 0) {
						bef ^= 1 << b + numSlots;
					} else {
						bef ^= 1 << b;
					}
					dp[mask] = Math.max(dp[mask], dp[bef] + (num & (b + 1)));
				}
			}
		}
		return dp[(1 << 2 * numSlots) - 1];
	}
}
