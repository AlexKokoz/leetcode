package org.leetcode.problems;

public class _000027_RemoveElement {
	public int removeElement(int[] nums, int val) {
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[len++] = nums[i];
			}
		}
		return len;
	}
}
