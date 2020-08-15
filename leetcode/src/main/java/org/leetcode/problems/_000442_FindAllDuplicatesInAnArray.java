package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000442_FindAllDuplicatesInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
				swap(i, nums[i] - 1, nums);
		}

		for (int i = 0; i < nums.length; i++)
			if (nums[i] != i + 1) {
				if (nums[i] != 0 && nums[i] != i + 1 && nums[nums[i] - 1] != 0) {
					ans.add(nums[i]);
					nums[nums[i] - 1] = 0;
				}
			}
		return ans;
	}

	static void swap(int i, int j, int[] a) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
