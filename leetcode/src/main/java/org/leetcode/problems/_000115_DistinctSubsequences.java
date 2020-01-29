package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000115_DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int sn = s.length();
		int tn = t.length();
		int[][] dp = new int[tn + 1][sn + 1];
		Arrays.fill(dp[0], 1);

		for (int i = 0; i < tn; i++) {
			for (int j = 0; j < sn; j++) {

				// at least all the subsequences for S[0..i] for current target character
				dp[i + 1][j + 1] = dp[i + 1][j];

				// current matched character adds the whole set of subsequences found before it
				if (s.charAt(j) == t.charAt(i))
					dp[i + 1][j + 1] += dp[i][j];
			}
		}

		return dp[tn][sn];

	}
}
