package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000031_NextPermutation {
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int i;
		for (i = n - 1; i > 0 && nums[i - 1] >= nums[i]; i--)
			;
		if (i == 0) {
			reverse(0, n - 1, nums);
		} else {
			int j;
			for (j = n - 1; nums[j] <= nums[i - 1]; j--)
				;
			swap(i - 1, j, nums);
			reverse(i, n - 1, nums);
		}
	}

	void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void reverse(int l, int r, int[] arr) {
		int n = r - l + 1;
		int mid = n / 2;
		for (int i = 0; i < mid; i++)
			swap(l + i, r - i, arr);
	}
}
