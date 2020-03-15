package org.leetcode.contests.weekly.w0180;

import java.util.*;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001380_LuckyNumbersInAMatrix {
	public List<Integer> luckyNumbers(int[][] m) {
		List<Integer> ans = new LinkedList<>();
		int nr = m.length;
		int nc = m[0].length;
		int[] mins = new int[nr];
		Arrays.fill(mins, Integer.MAX_VALUE);
		int[] maxes = new int[nc];
		Arrays.fill(maxes, Integer.MIN_VALUE);
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				mins[r] = Math.min(mins[r], m[r][c]);
				maxes[c] = Math.max(maxes[c], m[r][c]);
			}
		}
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (mins[r] == m[r][c] && maxes[c] == m[r][c])
					ans.add(m[r][c]);
			}
		}
		return ans;
	}
}
