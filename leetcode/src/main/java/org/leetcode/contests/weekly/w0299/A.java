package org.leetcode.contests.weekly.w0299;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public boolean checkXMatrix(int[][] grid) {
		int n = grid.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					if (grid[i][j] == 0)
						return false;
				} else if (i + j == n - 1) {
					if (grid[i][j] == 0)
						return false;
				} else {
					if (grid[i][j] != 0)
						return false;
				}
			}
		}
		return true;
	}
}
