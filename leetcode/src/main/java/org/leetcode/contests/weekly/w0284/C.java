package org.leetcode.contests.weekly.w0284;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maximumTop(int[] nums, int k) {
		int n = nums.length;
		int ans = -1;
		if (k % 2 == 1 && n == 1) return -1;
		for (int i = 0; i <= Math.min(n - 1, k); i++) {
			if (i == k - 1) continue;
			ans = Math.max(ans, nums[i]);
		}
		return ans;
	}
}
