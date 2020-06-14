package org.leetcode.contests.biweekly.bw0028;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _001477_FindTwoNonoverlappingSubarraysEachWithTargetSum {
	public int minSumOfLengths(int[] arr, int target) {
		int n = arr.length;
		Map<Integer, Integer> pos = new HashMap<>();
		pos.put(target, 0);
		int pref = 0;
		List<int[]> intervals = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			pref += arr[i];
			if (arr[i] > target)
				continue;
			if (arr[i] == target) {
				intervals.add(new int[] { i, i });
				continue;
			}
			if (pos.containsKey(pref)) {
				intervals.add(new int[] { pos.get(pref), i });
			}
			pos.put(pref + target - arr[i], i);
		}
		if (intervals.size() < 2)
			return -1;
		Collections.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				int l1 = a[1] - a[0] + 1;
				int l2 = b[1] - b[0] + 1;
				return l1 - l2;
			}
		});
		int[] first = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			int[] curr = intervals.get(i);
			if (curr[0] > first[1] || curr[1] < first[0]) {
				return first[1] - first[0] + 1 + curr[1] - curr[0] + 1;
			}
		}
		return -1;
	}
}
