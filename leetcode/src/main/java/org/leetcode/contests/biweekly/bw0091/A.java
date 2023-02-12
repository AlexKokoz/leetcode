package org.leetcode.contests.biweekly.bw0091;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int distinctAverages(int[] nums) {
		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums);
		for (int l = 0, r = n - 1; l < r; l++, r--) {
			set.add(nums[l] + nums[r]);
		}
		return set.size();
	}
}
