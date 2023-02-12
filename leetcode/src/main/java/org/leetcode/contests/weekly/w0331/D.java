package org.leetcode.contests.weekly.w0331;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long minCost(int[] basket1, int[] basket2) {
		int n = basket1.length;
		long ans = 0;
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for (int num : basket1) {
			map1.put(num, map1.getOrDefault(num, 0) + 1);
			map.put(num, map.getOrDefault(num, 0) + 1);
			min = Math.min(min, num);
		}
		for (int num : basket2) {
			map2.put(num, map2.getOrDefault(num, 0) + 1);
			map.put(num, map.getOrDefault(num, 0) + 1);
			min = Math.min(min, num);
		}
		for (int value : map.values()) {
			if (value % 2 == 1)
				return -1;
		}
		Arrays.sort(basket1);
		Deque<Integer> dq1 = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (i == 0 || basket1[i] != basket1[i - 1]) {
				for (int j = 0; j < Math.max(0, map1.get(basket1[i]) - map.get(basket1[i]) / 2); j++) {
					dq1.addLast(basket1[i]);
				}
			}
		}
		Arrays.sort(basket2);
		Deque<Integer> dq2 = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (i == 0 || basket2[i] != basket2[i - 1]) {
				for (int j = 0; j < Math.max(0, map2.get(basket2[i]) - map.get(basket2[i]) / 2); j++) {
					dq2.addLast(basket2[i]);
				}
			}
		}

		if (!dq1.isEmpty() && dq1.peekFirst() > dq2.peekFirst()) {
			Deque<Integer> swap = dq2;
			dq2 = dq1;
			dq1 = swap;
		}
		while (!dq1.isEmpty() && dq1.peekFirst() == min) {
			ans += dq1.pollFirst();
			dq2.pollLast();
		}

		while (!dq1.isEmpty()) {
			if (dq1.peekFirst() > dq2.peekFirst()) {
				Deque<Integer> swap = dq2;
				dq2 = dq1;
				dq1 = swap;
			}
			if (dq1.peekFirst() < 2 * min) {
				ans += dq1.pollFirst();
				dq2.pollLast();
			} else {
				ans += 2 * min;
				dq1.pollFirst();
				dq2.pollLast();
			}
		}
		return ans;
	}
}
