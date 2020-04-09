package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000268_MissingNumber {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] < n && nums[i] != i)
				swap(i, nums[i], nums);
		}
		for (int i = 0; i < n; i++)
			if (nums[i] != i)
				return i;
		return n;
	}

	void swap(int i, int j, int[] arr) {
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
}
