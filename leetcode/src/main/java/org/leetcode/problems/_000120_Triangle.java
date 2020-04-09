package org.leetcode.problems;

import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		final int n = triangle.size();
		if (n == 0)
			return 0;
		for (int r = 1; r < n; r++) {
			final List<Integer> prevLevel = triangle.get(r - 1);
			final List<Integer> currLevel = triangle.get(r);
			final int C = currLevel.size();
			for (int c = 0; c < C; c++) {
				int prevElem = (c - 1 >= 0 ? prevLevel.get(c - 1) : Integer.MAX_VALUE);
				int nextElem = (c < prevLevel.size() ? prevLevel.get(c) : Integer.MAX_VALUE);
				int min = Math.min(prevElem, nextElem);
				currLevel.set(c, currLevel.get(c) + min);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int x : triangle.get(n - 1))
			min = Math.min(min, x);
		return min;
	}
}
