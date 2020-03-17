package org.leetcode.problems;

public class _000026_RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0|| nums[i] != nums[i - 1])
				nums[len++] = nums[i];
		}
		return len;
	}
}
