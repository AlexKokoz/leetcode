package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000053_SubarraySum {
	public int maxSubArray(int[] nums) {
		int gSum = nums[0];
		int lSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			lSum = Math.max(lSum + nums[i], nums[i]);
			gSum = Math.max(gSum, lSum);
		}
		return gSum;
	}
}
