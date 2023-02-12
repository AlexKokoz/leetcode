package org.leetcode.contests.weekly.w0296;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int minMaxGame(int[] nums) {
		while (nums.length > 1) {
			int n = nums.length;
			int[] nums2 = new int[n / 2];
			for (int i = 0; i < n / 2; i++) {
				if (i % 2 == 0) {
					nums2[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
				} else {
					nums2[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
				}
			}
			nums = nums2;
		}
		return nums[0];
	}
}
