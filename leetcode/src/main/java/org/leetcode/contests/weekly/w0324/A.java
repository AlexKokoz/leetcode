package org.leetcode.contests.weekly.w0324;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int deleteGreatestValue(int[][] grid) {
		int ans = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int[] row : grid) {
			Arrays.sort(row);
		}
		for (int j = m - 1; j >= 0; j--) {
			int max = 0;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, grid[i][j]);
			}
			ans += max;
		}
		return ans;
	}
}
