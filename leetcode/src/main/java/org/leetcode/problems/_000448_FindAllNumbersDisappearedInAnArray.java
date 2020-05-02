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
		int n = nums.length;
		List<Integer> ans = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			while (nums[nums[i] - 1] != nums[i])
				swap(i, nums[i] - 1, nums);
		}
		for (int i = 0; i < n; i++)
			if (nums[i] != i + 1)
				ans.add(i + 1);
		return ans;
	}

	void swap(int i, int j, int[] nums) {
		int swap = nums[i];
		nums[i] = nums[j];
		nums[j] = swap;
	}
}
