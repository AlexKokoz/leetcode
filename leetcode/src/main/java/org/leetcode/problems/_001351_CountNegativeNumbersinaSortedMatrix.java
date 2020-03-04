package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001351_CountNegativeNumbersinaSortedMatrix {
	public int countNegatives(int[][] grid) {
		int nr = grid.length;
		int nc = grid[0].length;
		int count = 0;
		for (int r = 0; r < nr; r++) {
			for (int c = nc - 1; c >= 0; c--) {
				if (grid[r][c] >= 0) break;
				count++;
			}
		}
		return count;

	}
}
