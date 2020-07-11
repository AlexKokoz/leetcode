package org.leetcode.contests.biweekly.bw0030;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001509_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
	public int minDifference(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		if (n <= 4) min = 0;
		else if (n == 5) {
			for (int i = 0; i< n - 1; i++) {
				min = Math.min(min, nums[i + 1] - nums[i]);
			}
		} else {
			min = Math.min(min, nums[n - 1] - nums[3]);
			min = Math.min(min, nums[n - 2] - nums[2]);
			min = Math.min(min, nums[n - 3] - nums[1]);
			min = Math.min(min, nums[n - 4] - nums[0]);
		}
		return min;
	}
}
