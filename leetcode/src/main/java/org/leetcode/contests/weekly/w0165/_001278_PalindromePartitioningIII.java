package org.leetcode.contests.weekly.w0165;

import java.util.Arrays;

/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001278_PalindromePartitioningIII {

	public int palindromePartition(String s, int k) {
		final int n = s.length();
		final int[][] dp = new int[n + 1][n + 1];
		for (int[] a : dp)
			Arrays.fill(a, n + 100);
		dp[0][0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int l = 1; i + l <= n; l++) {
					int cost = 0;
					for (int z = 0; z < l / 2; z++) {
						cost += (s.charAt(i + z) != s.charAt(i + l - z - 1)) ? 1 : 0;
					}
					dp[i + l][j + 1] = Math.min(dp[i + l][j + 1], dp[i][j] + cost);
				}
			}
		}
		return dp[n][k];
	}
}
