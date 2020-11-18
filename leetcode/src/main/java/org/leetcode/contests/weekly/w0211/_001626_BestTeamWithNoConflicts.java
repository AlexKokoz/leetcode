package org.leetcode.contests.weekly.w0211;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001626_BestTeamWithNoConflicts {
	public int bestTeamScore(int[] scores, int[] ages) {
		int n = scores.length;
		int[][] as = new int[n][2];
		for (int i = 0; i < n; i++)
			as[i] = new int[] { ages[i], scores[i] };

		Arrays.sort(as, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (b[0] == a[0])
					return b[1] - a[1];
				return b[0] - a[0];
			}
		});

		int[] dp = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			int score = as[i][1];
			dp[i] = score;
			for (int j = 0; j < i; j++) {
				if (as[j][1] >= as[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + score);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;

	}
}
