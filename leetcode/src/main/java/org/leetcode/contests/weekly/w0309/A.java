package org.leetcode.contests.weekly.w0309;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {

	public int numberOfWays(int start, int end, int k) {
		long mod = 1000000007;
		Map<Integer, Long> dp = new HashMap<>();
		int offset = 2500;
		dp.put(offset, 1L);
		for (int i = 0; i < k; i++) {
			Map<Integer, Long> ndp = new HashMap<>();
			for (int key : dp.keySet()) {
				ndp.put(key - 1, (ndp.getOrDefault(key - 1, 0L) + dp.get(key)) % mod);
				ndp.put(key + 1, (ndp.getOrDefault(key + 1, 0L) + dp.get(key)) % mod);
			}
			dp = ndp;
		}
		return dp.getOrDefault(offset + end - start, 0L).intValue();
	}
}
