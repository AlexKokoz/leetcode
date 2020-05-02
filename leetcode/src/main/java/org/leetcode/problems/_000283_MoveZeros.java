package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000283_MoveZeros {
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		int len = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0)
				nums[len++] = nums[i];
		}
		for (int i = len; i < n; i++)
			nums[i] = 0;
	}
}
