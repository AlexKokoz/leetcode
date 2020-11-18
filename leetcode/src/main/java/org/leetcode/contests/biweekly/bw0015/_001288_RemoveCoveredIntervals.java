package org.leetcode.contests.biweekly.bw0015;

import java.util.Arrays;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001288_RemoveCoveredIntervals {

	public int removeCoveredIntervals(int[][] intervals) {
		int n = intervals.length;
		int ans = n;
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] != b[0])
				return a[0] - b[0];
			return b[1] - a[1];
		});
		int i = 0;
		while (i < n) {
			int j = i + 1;
			while (j < n && covers(intervals[i], intervals[j])) {
				ans--;
				j++;
			}
			i = j;
		}
		return ans;
	}

	boolean covers(int[] a, int[] b) {
		return a[0] <= b[0] && b[1] <= a[1];
	}
}
