package org.leetcode.contests.weekly.w0207;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001594_MaximumNonNegativeProductInAMatrix {
	long max = -1;

	public int maxProductPath(int[][] mat) {
		dfs(0, 0, mat, mat[0][0]);
		return max < 0 ? -1 : (int) (max % 1000000007);
	}

	void dfs(int r, int c, int[][] mat, long prod) {
		if (prod == 0) {
			max = Math.max(max, 0);
			return;
		}
		if (r == mat.length - 1 && c == mat[0].length - 1) {
			max = Math.max(max, prod);
			return;
		}
		if (r + 1 < mat.length)
			dfs(r + 1, c, mat, prod * mat[r + 1][c]);
		if (c + 1 < mat[0].length)
			dfs(r, c + 1, mat, prod * mat[r][c + 1]);
	}
}
