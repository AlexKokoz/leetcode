package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;

		// Build product prefix
		int[] lr = new int[n + 1];
		lr[0] = 1;
		for (int i = 0; i < n; i++)
			lr[i + 1] = lr[i] * nums[i];

		// Build product suffix
		int[] rl = new int[n + 1];
		rl[n] = 1;
		for (int i = n - 1; i >= 0; i--)
			rl[i] = rl[i + 1] * nums[i];

		// Calculate products for each i using the previous prefix and the next suffix
		for (int i = 0; i < n; i++) 
			nums[i] = lr[i] * rl[i + 1];

		return nums;
	}
}
