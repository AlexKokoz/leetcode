package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001051_HeightChecker {
	public int heightChecker(int[] heights) {
		int[] sorted = Arrays.copyOf(heights, heights.length);
		Arrays.sort(sorted);
		int count = 0;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] != sorted[i])
				count++;
		}
		return count;
	}
}
