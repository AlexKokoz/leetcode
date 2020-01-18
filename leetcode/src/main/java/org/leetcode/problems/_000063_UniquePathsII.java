package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000063_UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int nr = obstacleGrid.length;
		if (nr == 0)
			return 0;
		int nc = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[nr - 1][nc - 1] == 1)
			return 0;
		int[] ways = new int[nc + 1];
		ways[1] = 1;
		for (int c = 1; c < nc; c++)
			ways[c + 1] = obstacleGrid[0][c] == 1 ? 0 : ways[c];
		for (int r = 1; r < nr; r++) {
			int[] nways = new int[nc + 1];
			for (int c = 0; c < nc; c++) {
				int topWays = ways[c + 1];
				int leftWays = nways[c];
				nways[c + 1] = obstacleGrid[r][c] == 1 ? 0 : topWays + leftWays;
			}
			ways = nways;
		}
		return ways[nc];
	}
}
