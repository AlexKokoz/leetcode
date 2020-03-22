package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000329_LongestIncreasingPathInAMatrix {
	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int longestIncreasingPath(int[][] a) {
		int nr = a.length;
		if (nr == 0)
			return 0;
		int nc = a[0].length;
		int[][] memo = new int[nr][nc];
		int max = 0;
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				dfs(r, c, a, memo);
			}
		}
		for (int[] row : memo)
			for (int step : row)
				max = Math.max(max, step);
		return max;
	}

	int dfs(int r, int c, int[][] a, int[][] memo) {
		if (memo[r][c] > 0)
			return memo[r][c];
		memo[r][c] = 1;
		int maxNei = 0;
		for (int[] dir : dirs) {
			int nr = r + dir[0];
			int nc = c + dir[1];
			if (nr < 0 || nc < 0 || nr >= a.length || nc >= a[0].length)
				continue;
			if (a[nr][nc] < a[r][c])
				maxNei = Math.max(maxNei, dfs(nr, nc, a, memo));
		}
		memo[r][c] += maxNei;
		return memo[r][c];
	}
}
