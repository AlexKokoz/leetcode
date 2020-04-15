package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000152_MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int n = nums.length;
		boolean hasZero = false;

		// Build product prefix
		int[] lr = new int[n + 1];
		lr[0] = 1;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0)
				hasZero = true;
			if (nums[i] == 0)
				lr[i + 1] = 0;
			else if (i > 0 && nums[i - 1] == 0) // if back element is 0 treat it as 1
				lr[i + 1] = nums[i];
			else
				lr[i + 1] = lr[i] * nums[i];
		}

		// Build product suffix
		int[] rl = new int[n + 1];
		rl[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] == 0)
				rl[i] = 0;
			else if (i < n - 1 && nums[i + 1] == 0) // if front element is 0 treat it as 1
				rl[i] = nums[i];
			else
				rl[i] = rl[i + 1] * nums[i];
		}

		// The max product of a subarray will be either a prefix or a suffix product
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++)
			max = Math.max(max, lr[i]);
		for (int i = 0; i < n; i++)
			max = Math.max(max, rl[i]);
		if (hasZero && max < 0)
			return 0;
		return max;
	}
}
