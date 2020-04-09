package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000039_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ans = new LinkedList<>();
		dfs(candidates, ans, new LinkedList<>(), 0, 0, target);
		return ans;
	}

	void dfs(int[] nums, List<List<Integer>> ans, List<Integer> curlist, int curIndex, int curSum, int target) {
		if (curSum == target)
			ans.add(new LinkedList<>(curlist));
		if (curSum > target)
			return;
		for (int i = curIndex; i < nums.length; i++) {
			int num = nums[i];
			curlist.add(num);
			dfs(nums, ans, curlist, i, curSum + num, target);
			curlist.remove(curlist.size() - 1);
		}

	}
}
