package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000516_LongestPalindromicSubsqeuence {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n]; // length of LPS in range s[L..R]

		for (int i = 0; i < n; i++)
			dp[i][i] = 1; // single characters are a PS of length 1

		for (int len = 1; len < n; len++) {
			for (int L = 0; L < n - len; L++) {
				int R = L + len;
				if (s.charAt(L) == s.charAt(R)) {
					dp[L][R] = (L < R - 1 ? dp[L + 1][R - 1] : 0) + 2;
				} else {
					dp[L][R] = Math.max(dp[L + 1][R], dp[L][R - 1]);
				}
			}
		}

		return dp[0][n - 1];
	}
}
