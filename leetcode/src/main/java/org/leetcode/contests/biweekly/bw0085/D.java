package org.leetcode.contests.biweekly.bw0085;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
		int n = nums.length;
		long[] ans = new long[n];
		TreeSet<Integer> set = new TreeSet<>();
		TreeMap<Long, Integer> map = new TreeMap<>();
		long[] cum = new long[n + 1];
		for (int i = 0; i < n; i++) {
			cum[i + 1] = cum[i] + nums[i];
		}
		map.put(cum[n], 1);
		set.add(-1);
		set.add(n);
		for (int i = 0; i < n; i++) {
			int pos = removeQueries[i];
			int lower = set.lower(pos);
			int higher = set.higher(pos);
			long sum = cum[higher] - cum[lower + 1];
			map.put(sum, map.get(sum) - 1);
			if (map.get(sum) == 0)
				map.remove(sum);
			if (lower != pos - 1) {
				long lowerSum = cum[pos] - cum[lower + 1];
				map.put(lowerSum, map.getOrDefault(lowerSum, 0) + 1);
			}
			if (higher != pos + 1) {
				long higherSum = cum[higher] - cum[pos + 1];
				map.put(higherSum, map.getOrDefault(higherSum, 0) + 1);
			}
			ans[i] = map.isEmpty() ? 0 : map.lastKey();
			set.add(removeQueries[i]);
		}
		return ans;
	}
}
