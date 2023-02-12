package org.leetcode.contests.weekly.w0278;

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
	public int findFinalValue(int[] nums, int original) {
		Set<Integer> set = new HashSet<>();
		for (int x : nums)
			set.add(x);
		int max = Integer.MIN_VALUE;
		for (int x : nums) {
			max = Math.max(max, x);
		}
		while (original <= max) {
			if (set.contains(original)) {
				original *= 2;
			} else {
				break;
			}
		}
		return original;
	}
}
