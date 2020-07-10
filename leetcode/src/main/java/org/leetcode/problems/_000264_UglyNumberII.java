package org.leetcode.problems;

import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000264_UglyNumberII {
	public int nthUglyNumber(int n) {
		TreeSet<Long> set = new TreeSet<>();
		set.add(1L);
		for (int i = 1; i < n; i++) {
			long cur = set.pollFirst();
			set.add(cur * 2);
			set.add(cur * 3);
			set.add(cur * 5);
		}
		return set.pollFirst().intValue();
	}
}
