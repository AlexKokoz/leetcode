package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000075_SortColors {
	public void sortColors(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}

	static void sort(int[] arr, int lo, int hi) {
		if (hi <= lo)
			return; // range of 1 element or less
		int lt = lo;
		int gt = hi;
		int i = lo + 1;
		int pivot = arr[lo];
		while (i <= gt) {
			int cur = arr[i];
			if (cur < pivot)
				swap(i++, lt++, arr);
			else if (cur > pivot)
				swap(i, gt--, arr);
			else
				i++;
		}

		sort(arr, lo, lt - 1);
		sort(arr, gt + 1, hi);
	}

	static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
