package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000712_MinimumASCIIDeleteSumForTwoStrings {
	public int minimumDeleteSum(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];

		for (int i = 0; i < n1; i++)
			dp[i + 1][0] = dp[i][0] + s1.charAt(i);

		for (int i = 0; i < n2; i++)
			dp[0][i + 1] = dp[0][i] + s2.charAt(i);

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(j);
				if (c1 == c2)
					dp[i + 1][j + 1] = dp[i][j];
				else
					// min from removing last letter from either s1[0..i] or s2[0..j]
					dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + c1, dp[i + 1][j] + c2);
			}
		}
		return dp[n1][n2];
	}
}
