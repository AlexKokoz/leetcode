package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000643_MaximumAverageSubarrayI {
	public double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		double sum = 0;
		for (int i = 0; i < k; i++)
			sum += nums[i];
		double maxAvg = sum / k;
		for (int i = k; i < n; i++) {
			sum += nums[i] - nums[i - k];
			maxAvg = Math.max(maxAvg, sum / k);
		}
		return maxAvg;
	}
}
