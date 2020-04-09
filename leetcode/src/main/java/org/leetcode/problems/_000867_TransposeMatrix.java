package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000867_TransposeMatrix {
	public int[][] transpose(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int[][] transposed = new int[m][n];
		for (int r = 0; r < n; r++)
			for (int c = 0; c < m; c++)
				transposed[c][r] = A[r][c];
		return transposed;
	}
}
