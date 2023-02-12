package org.leetcode.contests.biweekly.bw0061;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long maxTaxiEarnings(int n, int[][] rides) {
		long ans = 0;
		Arrays.sort(rides, (a, b) -> {
			if (a[1] != b[1])
				return Integer.compare(a[1], b[1]);
			return Integer.compare(a[0], b[0]);
		});
		TreeMap<Integer, Long> map = new TreeMap<>();
		for (int[] r : rides) {
			Integer floor = map.floorKey(r[0]);
			long cand = floor == null ? 0 : map.get(floor);
			cand += r[1] - r[0] + r[2];
			ans = Math.max(ans, cand);

			map.put(r[1], ans);
		}

		return ans;
	}
}
