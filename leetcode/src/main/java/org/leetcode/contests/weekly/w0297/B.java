package org.leetcode.contests.weekly.w0297;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minPathCost(int[][] grid, int[][] moveCost) {
		int n = grid.length;
		int m = grid[0].length;
		int[] dp = Arrays.copyOf(grid[0], m);
		for (int r = 1; r < n; r++) {
			int[] ndp = new int[m];
			Arrays.fill(ndp, Integer.MAX_VALUE / 2);
			for (int c = 0; c < m; c++) {
				for (int cc = 0; cc < m; cc++) {
					ndp[cc] = Math.min(ndp[cc], dp[c] + moveCost[grid[r - 1][c]][cc] + grid[r][cc]);
				}
			}
			dp = ndp;
		}

		int min = Integer.MAX_VALUE;
		for (int x : dp)
			min = Math.min(min, x);
		return min;
	}
}
