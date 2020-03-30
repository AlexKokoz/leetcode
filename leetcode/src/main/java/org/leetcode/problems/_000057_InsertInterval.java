package org.leetcode.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * HARD
 * 
 * @author akokozidis
 *
 */
public class _000057_InsertInterval {
	
	public int[][] insert(int[][] intervals, int[] target) {
		List<int[]> list = new LinkedList<>();
		for (int[] interval : intervals)
			list.add(interval);
		list.add(target);

		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] < b[0])
					return -1;
				if (a[0] > b[0])
					return 1;
				return 0;
			}
		});

		for (int i = 1; i < list.size(); i++) {
			int[] prev = list.get(i - 1);
			int[] cur = list.get(i);
			if (intersects(prev, cur)) {
				int[] mergedInterval = { Math.min(cur[0], prev[0]), Math.max(cur[1], prev[1]) };
				list.set(i, mergedInterval);
				list.set(i - 1, null);
			}
		}

		int count = 0;
		for (int[] interval : list)
			if (interval != null)
				count++;

		int[][] ans = new int[count][];
		int index = 0;
		for (int[] interval : list)
			if (interval != null)
				ans[index++] = interval;
		return ans;
	}

	boolean intersects(int[] a, int[] b) {
		return a[0] <= b[1] && b[0] <= a[1];
	}
}
