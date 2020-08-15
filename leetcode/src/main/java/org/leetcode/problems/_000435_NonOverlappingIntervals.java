package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000435_NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length;
		if (n == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		int maxNonOverlapping = 1;
		for (int i = 1, prev = 0; i < n; i++) {
			if (!intersect(intervals[i], intervals[prev])) {
				System.out.println(i);
				prev = i;
				maxNonOverlapping++;
			}

		}
		return n - maxNonOverlapping;
	}

	boolean intersect(int[] a, int[] b) {
		return a[0] < b[1] && b[0] < a[1];
	}
}
