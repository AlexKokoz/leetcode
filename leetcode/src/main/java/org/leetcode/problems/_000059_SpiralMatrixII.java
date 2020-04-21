package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000059_SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int[][] matrix = new int[n][n];
		int r = 0;
		int c = -1;
		int dir = 0;
		
		for (int i = 1; i <= n * n; i++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if (nr < 0 || nc < 0 || nr == n || nc == n || matrix[nr][nc] != 0) {
				dir = (dir + 1) % 4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}

			matrix[nr][nc] = i;
			
			r = nr;
			c = nc;
		}

		return matrix;
	}
}
