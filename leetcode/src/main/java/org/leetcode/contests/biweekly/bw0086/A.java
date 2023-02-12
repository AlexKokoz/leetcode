package org.leetcode.contests.biweekly.bw0086;

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
	public boolean findSubarrays(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			int sum = nums[i] + nums[i + 1];
			if (seen.contains(sum))
				return true;
			seen.add(sum);
		}
		return false;
	}
}
