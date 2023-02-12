package org.leetcode.contests.weekly.w0277;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;
		List<Integer> poss = new ArrayList<>();
		List<Integer> negs = new ArrayList<>();
		for (int num : nums) {
			if (num > 0)
				poss.add(num);
			else
				negs.add(num);
		}
		for (int i = 0; i < n; i += 2) {
			nums[i] = poss.get(i / 2);
			nums[i + 1] = negs.get(i / 2);
		}
		return nums;
	}
}
