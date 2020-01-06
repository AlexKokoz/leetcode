package org.leetcode.contests.weekly.w0168;

import java.util.TreeMap;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001296_DivideArrayInSetsOfKConsqutiveNumbers {
	public boolean isPossibleDivide(int[] a, int k) {
		final int n = a.length;
		if (n % k != 0)
			return false;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int x : a) {
			if (map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put(x, 1);
		}
		while (!map.isEmpty()) {
			int lo = map.firstKey();
			map.put(lo, map.get(lo) - 1);
			if (map.get(lo) == 0)
				map.remove(lo);
			for (int i = 1; i < k; i++) {
				if (!map.containsKey(lo + i))
					return false;
				else
					map.put(lo + i, map.get(lo + i) - 1);
				if (map.get(lo + i) == 0)
					map.remove(lo + i);
			}
		}
		return true;
	}
}
