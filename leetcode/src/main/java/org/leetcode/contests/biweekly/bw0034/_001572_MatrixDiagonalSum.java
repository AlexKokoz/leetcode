package org.leetcode.contests.biweekly.bw0034;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001572_MatrixDiagonalSum {
	public int diagonalSum(int[][] mat) {
		int n = mat.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += mat[i][i];
		for (int c = 0, r = n - 1; c < n; c++, r--) {
			sum += mat[r][c];
		}
		if (n % 2 == 1)
			sum -= mat[n / 2][n / 2];
		return sum;
	}
}
