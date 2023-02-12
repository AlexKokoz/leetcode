package org.leetcode.contests.weekly.w0258;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {

	public long interchangeableRectangles(int[][] rs) {

		Map<Double, Long> map = new HashMap<>();
		long ans = 0;
		for (int[] r : rs) {

			double ratio = (double) r[0] / r[1];
			long count = map.getOrDefault(ratio, 0L);
			ans += count;
			map.put(ratio, count + 1);
		}
		return ans;
	}
}
