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
public class _000056_MergeIntervals {
	public int[][] merge(int[][] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return a[0] - b[0];
				return a[1] - b[1];
			}
		});
		int p = n;
		for (int i = 1, j = 0; i < n; i++) {
			int[] prev = intervals[j];
			int[] curr = intervals[i];
			if (intersect(curr, prev)) {
				intervals[i][0] = Math.min(curr[0], prev[0]);
				intervals[i][1] = Math.max(curr[1], prev[1]);
				intervals[j] = null;
				p--;
			}
			j = i;
		}
		int[][] ans = new int[p][];
		for (int i = 0, pos = 0; i < n; i++) {
			if (intervals[i] != null) {
				ans[pos++] = intervals[i];
			}
		}
		return ans;
	}

	static boolean intersect(int[] a, int[] b) {
		return a[0] <= b[1] && b[0] <= a[1];
	}
}
