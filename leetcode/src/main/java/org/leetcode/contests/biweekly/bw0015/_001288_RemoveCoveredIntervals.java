package org.leetcode.contests.biweekly.bw0015;

import java.util.Arrays;
import java.util.Comparator;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001288_RemoveCoveredIntervals {

	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] < b[0])
					return -1;
				if (a[0] > b[0])
					return 1;
				if (a[1] < b[1])
					return 1;
				if (a[1] > b[1])
					return -1;
				return 0;
			}
		});
		final int n = intervals.length;
		int par = 0;
		int i = 1;
		int ans = 1;
		while (i < n) {
			if (!(intervals[par][0] <= intervals[i][0] && intervals[i][1] <= intervals[par][1])) {
				ans++;
				par = i;
			}
			i++;
		}
		return ans;
	}

}
