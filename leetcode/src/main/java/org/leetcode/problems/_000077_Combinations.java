package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new LinkedList<>();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		List<Integer> list = new LinkedList<>();
		permute(nums, list, ans, k, -1);
		return ans;
	}

	void permute(int[] nums, List<Integer> list, List<List<Integer>> ans, int k, int last) {
		if (list.size() == k) {
			ans.add(new LinkedList<>(list));
			return;
		}
		for (int i = last + 1; i < nums.length; i++) {
			list.add(nums[i]);
			permute(nums, list, ans, k, i);
			list.remove(list.size() - 1);
		}
	}
}
