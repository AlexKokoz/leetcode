package org.leetcode.contests.weekly.w0222;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001711_CountGoodMeals {
	public int countPairs(int[] deliciousness) {
		long[] p2 = new long[42];
		long mod = 1000000007;
		long ans = 0;
		p2[0] = 1;
		for (int i = 1; i < p2.length; i++)
			p2[i] = p2[i - 1] * 2;
		Map<Long, Integer> map = new HashMap<>();
		for (int num : deliciousness) {
			for (long p : p2) {
				if (map.containsKey(p - num)) {
					ans += map.get(p - num);
					ans %= mod;
				}
			}
			map.put((long) num, map.getOrDefault((long) num, 0) + 1);
		}
		return (int) ans;
	}
}
