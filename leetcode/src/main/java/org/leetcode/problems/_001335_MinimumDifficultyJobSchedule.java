package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001335_MinimumDifficultyJobSchedule {
	public int minDifficulty(int[] jobDifficulty, int d) {
		int n = jobDifficulty.length;
		if (d > n)
			return -1;
		long[] dp = new long[n + 1];
		long I = Long.MAX_VALUE / 3;

		long[][] jd = new long[n][n];
		for (int i = 0; i < n; i++) {
			long u = 0;
			for (int j = i; j < n; j++) {
				u = Math.max(u, jobDifficulty[j]);
				jd[i][j] = u;
			}
		}

		Arrays.fill(dp, I);
		dp[0] = 0;
		for (int i = 0; i < d; i++) {
			long[] ndp = new long[n + 1];
			Arrays.fill(ndp, I);
			for (int j = 0; j <= n; j++) {
				for (int k = j + 1; k <= n; k++) {
					ndp[k] = Math.min(ndp[k], dp[j] + jd[j][k - 1]);
				}
			}
			dp = ndp;
		}
		return (int) dp[n];
	}
}
