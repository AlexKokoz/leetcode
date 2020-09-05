package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class _001353_MaximumNumberOfEventsThatCanBeAttended {
	public int maxEvents(int[][] events) {

		int n = events.length;
		Arrays.sort(events, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 1; i <= events[n - 1][1]; i++)
			set.add(i);
		int ans = 0;
		for (int[] event : events) {
			Integer ceil = set.ceiling(event[0]);
			if (ceil != null && ceil <= event[1]) {
				ans++;
				set.remove(ceil);
			}
		}
		return ans;
	}
}
