package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000054_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new LinkedList<>();
		int n = matrix.length;
		if (n == 0)
			return ans;
		int m = matrix[0].length;
		boolean[][] seen = new boolean[n][m];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int r = 0;
		int c = -1;
		int dir = 0;
		for (int i = 0; i < n * m; i++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nc < 0 || nr == n || nc == m || seen[nr][nc]) {
				dir = (dir + 1) % 4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			ans.add(matrix[nr][nc]);
			seen[nr][nc] = true;
			r = nr;
			c = nc;
		}
		return ans;
	}
}
