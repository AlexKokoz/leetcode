package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000064_MinimumPathSum {
	public int minPathSum(int[][] a) {
		final int R = a.length;
		if (R == 0)
			return 0;
		final int C = a[0].length;
		for (int c = 1; c < C; c++)
			a[0][c] += a[0][c - 1];
		for (int r = 1; r < R; r++)
			a[r][0] += a[r - 1][0];
		for (int r = 1; r < R; r++) {
			for (int c = 1; c < C; c++) {
				a[r][c] = Math.min(a[r - 1][c], a[r][c - 1]) + a[r][c];
			}
		}
		return a[R - 1][C - 1];
	}
}
