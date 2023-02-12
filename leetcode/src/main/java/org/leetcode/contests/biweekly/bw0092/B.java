package org.leetcode.contests.biweekly.bw0092;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[][] onesMinusZeros(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] onesCol = new int[m];
		int[] onesRow = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				onesRow[i] += grid[i][j];
				onesCol[j] += grid[i][j];
			}
		}
		int[][] diff = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				diff[i][j] = onesRow[i] + onesCol[j] - (n - onesRow[i]) - (m - onesCol[j]);
			}
		}
		return diff;
	}
}
