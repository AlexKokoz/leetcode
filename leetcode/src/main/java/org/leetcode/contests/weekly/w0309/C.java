package org.leetcode.contests.weekly.w0309;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int longestNiceSubarray(int[] nums) {
		int n = nums.length;
		int ans = 1;
		int mask = 0;
		for (int l = 0, r = 0; r < n; r++) {
			if ((mask & nums[r]) == 0) {
				ans = Math.max(ans, r - l + 1);
				mask |= nums[r];
			} else {
				while (l < r && (mask & nums[r]) != 0) {
					mask ^= nums[l];
					l++;
				}
				mask |= nums[r];
				ans = Math.max(ans, r - l + 1);
			}
		}
		return ans;
	}
}
