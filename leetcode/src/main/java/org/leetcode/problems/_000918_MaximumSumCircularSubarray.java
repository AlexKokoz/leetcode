package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000918_MaximumSumCircularSubarray {
	public int maxSubarraySumCircular(int[] nums) {
		int n = nums.length;
		int sum = Arrays.stream(nums).parallel().sum();
		int lmax, gmax;
		gmax = lmax = nums[0];
		for (int i = 1; i < n; i++) {
			lmax = Math.max(lmax + nums[i], nums[i]);
			gmax = Math.max(gmax, lmax);
		}

		int gmin, lmin;
		gmin = lmin = nums[0];
		for (int i = 1; i < n; i++) {
			lmin = Math.min(lmin + nums[i], nums[i]);
			gmin = Math.min(gmin, lmin);
		}
		return sum == gmin ? gmax : Math.max(gmax, sum - gmin);
	}
}
