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
public class _000047_PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> ans = new LinkedList<>();
		boolean[] chosen = new boolean[n];
		permute(ans, new LinkedList<>(), nums, chosen);
		return ans;
	}

	void permute(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] chosen) {
		if (list.size() == nums.length) {
			ans.add(new LinkedList<>(list));
			return;
		}
		int last = -1;
		for (int i = 0; i < chosen.length; i++) {
			if (chosen[i])
				continue;
			if (last >= 0 && nums[i] == nums[last])
				continue;
			list.add(nums[i]);
			chosen[i] = true;
			permute(ans, list, nums, chosen);
			list.remove(list.size() - 1);
			chosen[i] = false;
			last = i;
		}
	}
}
