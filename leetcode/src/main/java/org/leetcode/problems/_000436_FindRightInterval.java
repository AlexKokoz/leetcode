package org.leetcode.problems;

import java.util.TreeMap;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000436_FindRightInterval {
	public int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		TreeMap<Integer, Integer> all = new TreeMap<>();
		int[] ans = new int[n];
		for (int i = 0; i < n; i++)
			all.put(intervals[i][0], i);
		for (int i = 0; i < n; i++) {
			int[] interval = intervals[i];
			Integer ceil = all.ceilingKey(interval[1]);
			if (ceil == null) {
				ans[i] = -1;
			} else {
				ans[i] = all.get(ceil);
			}
		}
		return ans;
	}
}
