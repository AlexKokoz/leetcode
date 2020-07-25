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
		int n = nums.length;
		List<List<Integer>> ans = new LinkedList<>();
		for (int i = 0; i < (1 << n); i++) {
			ans.add(build(nums, i));
		}
		return ans;
	}

	List<Integer> build(int[] nums, int mask) {
		List<Integer> ret = new LinkedList<>();
		int i = 0;
		while (mask > 0) {
			if ((mask & 1) == 1) {
				ret.add(nums[i]);
			}
			i++;
			mask >>= 1;
		}
		return ret;
	}
}
