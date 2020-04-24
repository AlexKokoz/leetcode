package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000073_SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int n = matrix.length;
		if (n == 0)
			return;
		int m = matrix[0].length;
		boolean[] rows = new boolean[n];
		boolean[] cols = new boolean[m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (matrix[r][c] == 0) {
					rows[r] = true;
					cols[c] = true;
				}
			}
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (rows[r] || cols[c]) {
					matrix[r][c] = 0;
				}
			}
		}
	}
}
