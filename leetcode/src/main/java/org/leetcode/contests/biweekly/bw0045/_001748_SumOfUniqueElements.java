package org.leetcode.contests.biweekly.bw0045;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001748_SumOfUniqueElements {
	public int sumOfUnique(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		int s = 0;
		for (int l = 0; l < n;) {
			int r = l;
			while (r < n && nums[r] == nums[l])
				r++;
			if (r - l == 1) {
				s += nums[l];
			}
			l = r;
		}
		return s;
	}
}
