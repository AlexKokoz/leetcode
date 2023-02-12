package org.leetcode.contests.weekly.w0224;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001726_TupleWithSameProduct {
	public int tupleSameProduct(int[] nums) {
		int n = nums.length;
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int prod = nums[i] * nums[j];
				map.put(prod, map.getOrDefault(prod, 0) + 1);
			}
		}
		System.out.println(map);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() < 2)
				continue;
			ans += (nChooseK(entry.getValue(), 2)) * 8;
		}
		return ans;
	}

	static long nChooseK(long n, long k) {
		long ans = 1;
		for (int i = 1; i <= n - k; i++) {
			ans *= k + i;
			ans /= i;
		}
		return ans;
	}
}
