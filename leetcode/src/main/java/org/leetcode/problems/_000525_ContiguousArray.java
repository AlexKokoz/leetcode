package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000525_ContiguousArray {
	public int findMaxLength(int[] a) {
		final int n = a.length;
		final Map<Integer, Integer> count2index = new HashMap<>();
		int count = 0;
		int max = 0;
		count2index.put(count, -1);
		for (int i = 0; i < n; i++) {
			count += (a[i] == 1 ? 1 : -1);
			if (count2index.containsKey(count)) { 
				max = Math.max(max, i - count2index.get(count));
			} else {
				count2index.put(count, i);
			}
		}
		return max;
	}
}
