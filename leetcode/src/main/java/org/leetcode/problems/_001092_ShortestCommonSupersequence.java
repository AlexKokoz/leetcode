package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001092_ShortestCommonSupersequence {

	/*
	 * Similar to github's diff function :)
	 */
	public String shortestCommonSupersequence(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];

		/*
		 * Build longest common subsequence lengths.
		 */
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(j);
				if (c1 == c2)
					dp[i + 1][j + 1] = dp[i][j] + 1;
				else
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
			}
		}

		/*
		 * Backtrack from the end to the start of each string, to build the supersequence. 
		 */
		StringBuilder sb = new StringBuilder();
		int i = n1;
		int j = n2;
		while (i != 0 && j != 0) {
			char c1 = s1.charAt(i - 1);
			char c2 = s2.charAt(j - 1);
			if (c1 == c2) {
				i--;
				j--;
				sb.append(c1);
			} else if (dp[i - 1][j] == dp[i][j]) {
				i--;
				sb.append(c1);
			} else { // dp[i][j - 1] == dp[i][j]
				j--;
				sb.append(c2);
			}
		}

		while (i > 0)
			sb.append(s1.charAt(--i));

		while (j > 0)
			sb.append(s2.charAt(--j));

		return sb.reverse().toString();
	}
}
