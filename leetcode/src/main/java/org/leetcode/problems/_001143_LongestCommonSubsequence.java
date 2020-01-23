package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001143_LongestCommonSubsequence {

	/*
	 * LCS(s1[0..i], s2[0..j]) =
	 * 
	 * 
	 * if s1[i] == s2[j] :
	 * 
	 * LCS( s1[0..i-1], s2[0..j-1]) + 1
	 * 
	 * else
	 * 
	 * max( LCS( s1[0..i], s2[0..j-1] ), LCS(s1[0..i-1], s2[0..j]) )
	 */
	public int longestCommonSubsequence(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(j);
				if (c1 == c2) // LCS(s1[0..i-1], s2[0..j-1]) + 1
					dp[i + 1][j + 1] = dp[i][j] + 1;
				else
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]); // max( LCS())
			}
		}
		return dp[n1][n2];
	}
}
