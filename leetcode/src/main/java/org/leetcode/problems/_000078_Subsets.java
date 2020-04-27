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
public class _000078_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		permute(nums, list, ans, -1);
		ans.add(new LinkedList<>());
		return ans;
	}

	void permute(int[] nums, List<Integer> list, List<List<Integer>> ans, int last) {
		for (int i = last + 1; i < nums.length; i++) {
			list.add(nums[i]);
			ans.add(new LinkedList<>(list));
			permute(nums, list, ans, i);
			list.remove(list.size() - 1);
		}
	}
}
