package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000041_FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int j = i;
			while (0 <= nums[j] && nums[j] < n && nums[nums[j]] != nums[j])
				swap(j, nums[j], nums);
		}
		for (int i = 1; i < n; i++)
			if (nums[i] != i)
				return i;
		if (nums.length > 0 && nums[0] == n)
			return n + 1;
		return Math.max(1, n);
	}

	void swap(int i, int j, int[] arr) {
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
}
