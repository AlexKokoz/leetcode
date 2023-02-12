package org.leetcode.contests.biweekly.bw0061;

import java.util.Arrays;
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
	public int[] findOriginalArray(int[] a) {
		int n = a.length;
		if (n % 2 == 1)
			return new int[0];
		Arrays.sort(a);
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : a)
			map.put(num, map.getOrDefault(num, 0) + 1);
		int[] ans = new int[n / 2];
		int p = 0;
		for (int num : a) {
			if (map.getOrDefault(num, 0) == 0)
				continue;
			// System.out.println(num);
			if (map.getOrDefault(num * 2, 0) == 0)
				return new int[0];
			map.put(num, map.get(num) - 1);
			map.put(num * 2, map.get(num * 2) - 1);
			if (p == n / 2)
				return new int[0];
			ans[p++] = num;
		}
		return ans;
	}
}
