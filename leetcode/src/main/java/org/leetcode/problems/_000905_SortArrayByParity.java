package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000905_SortArrayByParity {
	public int[] sortArrayByParity(int[] nums) {
		int n = nums.length;
		int lo = 0;
		int hi = n - 1;
		while (lo < hi) {
			while (lo < n && nums[lo] % 2 == 0)
				lo++;
			while (hi >= 0 && nums[hi] % 2 == 1)
				hi--;
			if (lo >= hi)
				break;
			swap(lo, hi, nums);
			lo++;
			hi--;
		}
		return nums;
	}

	void swap(int i, int j, int[] nums) {
		int swap = nums[i];
		nums[i] = nums[j];
		nums[j] = swap;
	}
}
