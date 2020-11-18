package org.leetcode.contests.weekly.w0209;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001608_SpecialArrayWithXElementsGreaterThanOrEqualX {
	public int specialArray(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int[] first = new int[1001];
		Arrays.fill(first, -1);
		for (int i = 0; i < n; i++)
			if (first[nums[i]] < 0)
				first[nums[i]] = i;
		for (int i = 1; i <= 1000; i++) {
			int pos = first[i];
			if (pos < 0)
				pos = -Arrays.binarySearch(nums, i) - 1;
			if (n - pos == i)
				return i;
		}
		return -1;
	}
}
