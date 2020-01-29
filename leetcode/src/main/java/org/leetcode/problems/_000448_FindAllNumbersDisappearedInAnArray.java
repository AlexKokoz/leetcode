package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000448_FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		final List<Integer> ans = new LinkedList<>();
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1)
				ans.add(i + 1);
		}
		return ans;
	}

	static void swap(int[] arr, int i, int j) {
		final int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
}
