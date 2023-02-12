package org.leetcode.contests.weekly.w0315;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int countDistinctIntegers(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
			set.add(rev(num));
		}
		return set.size();
	}

	int rev(int num) {
		int rev = Integer.parseInt(new StringBuilder().append(num).reverse().toString());
		return rev;
	}
}
