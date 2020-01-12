package org.leetcode.contests.weekly.w0171;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001320_MinimumDistanceToTypeAWordUsingTwoFingers {

	public int minimumDistance(String word) {
		int n = word.length();

		/*
		 * Current letter positions of the fingers.
		 * 
		 * 1st finger -> row, 2nd finger -> column
		 */
		int[][] dp = new int[26][26];

		for (int i = 0; i < n; i++) {
			int[][] ndp = new int[26][26];
			for (int[] row : ndp)
				Arrays.fill(row, Integer.MAX_VALUE / 2);
			int cur = word.charAt(i) - 'A';
			for (int f1 = 0; f1 < 26; f1++) {
				for (int f2 = 0; f2 < 26; f2++) {

					// Move first finger
					ndp[cur][f2] = Math.min(ndp[cur][f2], dp[f1][f2] + dist(f1, cur));

					// Move second finger
					ndp[f1][cur] = Math.min(ndp[f1][cur], dp[f1][f2] + dist(f2, cur));

				}
			}
			dp = ndp;
		}

		int ans = Integer.MAX_VALUE;
		for (int[] row : dp)
			for (int x : row)
				ans = Math.min(ans, x);
		return ans;
	}

	int dist(int a, int b) {
		return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
	}

}
