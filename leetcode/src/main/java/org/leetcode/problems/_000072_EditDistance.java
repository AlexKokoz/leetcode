package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000072_EditDistance {
	public int minDistance(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();

		int[] dp = new int[n2 + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}

		for (int i = 0; i < n1; i++) {
			int[] ndp = new int[dp.length];
			ndp[0] = i + 1;
			for (int j = 0; j < n2; j++) {
				char c1 = word1.charAt(i);
				char c2 = word2.charAt(j);
				if (c1 == c2) {
					ndp[j + 1] = dp[j];
				} else {
					ndp[j + 1] = Math.min(dp[j], Math.min(ndp[j], dp[j + 1])) + 1;
				}
			}
			dp = ndp;
		}
		return dp[n2];
	}
}
