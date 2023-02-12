package org.leetcode.contests.weekly.w0236;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001824_MinimumSidewayJumps {
	public int minSideJumps(int[] obstacles) {
		int n = obstacles.length;
		int[][] dp = new int[3][n];
		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE / 2);
		dp[1][0] = 0;
		for (int i = 0; i < n; i++) {
			if (i > 0) {
				for (int j = 0; j < 3; j++)
					if (obstacles[i] != j + 1 && obstacles[i - 1] != j + 1)
						dp[j][i] = dp[j][i - 1];
			}
			for (int to = 0; to < 3; to++) {
				if (obstacles[i] == to + 1)
					continue;
				for (int from = 0; from < 3; from++) {
					if (from == to || obstacles[i] == from + 1)
						continue;
					dp[to][i] = Math.min(dp[to][i], dp[from][i] + 1);
				}
			}
		}
		return Math.min(dp[0][n - 1], Math.min(dp[1][n - 1], dp[2][n - 1]));
	}
}
