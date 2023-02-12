package org.leetcode.contests.weekly.w0292;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int countTexts(String s) {
		int n = s.length();
		long mod = 1000000007;
		int[] size = { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
		long[] dp = new long[n + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int d = s.charAt(i) - '0';
			int rem = size[d];
			int j = i - 1;
			while (j >= 0 && rem > 0 && s.charAt(j) - '0' == d) {
				dp[i + 1] += dp[j + 1];
				if (dp[i + 1] >= mod)
					dp[i + 1] -= mod;
				j--;
				rem--;
			}
			if (rem > 0) {
				dp[i + 1] += dp[j + 1];
				if (dp[i + 1] >= mod)
					dp[i + 1] -= mod;
			}
		}
		return (int) dp[n];
	}
}
