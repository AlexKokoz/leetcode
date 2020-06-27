package org.leetcode.contests.weekly.w0192;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001473_PaintHouseIII {
	public int minCost(int[] houses, int[][] costs, int m, int n, int target) {
		int MAX = Integer.MAX_VALUE / 2;

		// dp[i][j] = min cost (for houses processed so far) with i neighborhoods and
		// with the last house painted with color j + 1(if it was not painted)
		int[][] dp = new int[target + 1][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, MAX);
		}
		dp[0][0] = 0;

		for (int currentHouse = 0; currentHouse < m; currentHouse++) {
			int[][] ndp = new int[dp.length][dp[0].length];
			for (int[] row : ndp) {
				Arrays.fill(row, MAX);
			}
			for (int currentTarget = 0; currentTarget <= target; currentTarget++) {
				for (int currentColor = 0; currentColor <= n; currentColor++) {
					if (houses[currentHouse] == 0) { // not painted
						for (int nextColor = 1; nextColor <= n; nextColor++) {
							int nextTarget = currentTarget;
							// if the color is changed between two adjacent houses,
							// increment neighborhoods
							if (currentColor != nextColor)
								nextTarget++;
							int cost = costs[currentHouse][nextColor - 1];
							if (dp[currentTarget][currentColor] == MAX
									|| nextTarget > target)
								continue;
							ndp[nextTarget][nextColor] = Math.min(
									ndp[nextTarget][nextColor],
									dp[currentTarget][currentColor] + cost);
						}
					} else { // already painted
						int cprv = houses[currentHouse];
						int tnxt = currentTarget;
						if (cprv != currentColor)
							tnxt++;
						if (tnxt > target)
							continue;
						ndp[tnxt][cprv] = Math.min(ndp[tnxt][cprv],
								dp[currentTarget][currentColor]);
					}
				}
			}
			dp = ndp;
		}

		int min = MAX;
		for (int c = 0; c <= n; c++) {
			min = Math.min(min, dp[target][c]);
		}

		return min == MAX ? -1 : min;
	}
}
