package org.leetcode.contests.weekly.w0306;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	int[][] d8 = new int[][] { { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { 0, 1 },
			{ 0, -1 } };

	public int[][] largestLocal(int[][] grid) {
		int n = grid.length;
		int[][] ans = new int[n - 2][n - 2];
		for (int i = 0; i < ans.length; i++) {
			int ii = i + 1;
			for (int j = 0; j < ans[0].length; j++) {
				int jj = j + 1;
				ans[i][j] = grid[ii][jj];
				for (int[] d : d8) {
					int iii = ii + d[0];
					int jjj = jj + d[1];
					ans[i][j] = Math.max(ans[i][j], grid[iii][jjj]);
				}
			}
		}
		return ans;
	}
}
