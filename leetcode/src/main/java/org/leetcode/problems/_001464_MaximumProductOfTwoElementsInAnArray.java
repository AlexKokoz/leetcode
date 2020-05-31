package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001464_MaximumProductOfTwoElementsInAnArray {
	public int maxProduct(int[] nums) {
		int n = nums.length;
		int max1 = -1;
		int index1 = -1;
		for (int i = 0; i < n; i++) {
			if (nums[i] > max1) {
				max1 = nums[i];
				index1 = i;
			}
		}
		int max2 = -1;
		for (int i = 0; i < n; i++) {
			if (i == index1)
				continue;
			if (nums[i] > max2) {
				max2 = nums[i];
			}
		}
		return (max1 - 1) * (max2 - 1);
	}
}
