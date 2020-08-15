package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001546_MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget {
	public int maxNonOverlapping(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		int pref = 0;
		int ans = 0;
		set.add(0);
		for (int num : nums) {
			pref += num;
			if (set.contains(pref - target)) {
				ans++;
				set.clear();
				set.add(0);
				pref = 0;
			}
			set.add(pref);
		}
		return ans;
	}
}
