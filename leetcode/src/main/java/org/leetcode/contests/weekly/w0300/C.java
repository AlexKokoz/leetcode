package org.leetcode.contests.weekly.w0300;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {

	public int peopleAwareOfSecret(int n, int delay, int forget) {
		long mod = 1000000007;
		long[] dp = new long[n + 1];
		long[] parents = new long[n + 1];
		parents[1] = 1;
		parents[2] = -1;
		for (int i = 1; i < n + 1; i++) {

			parents[i] += parents[i - 1];
			parents[i] %= mod;
			if (parents[i] < 0)
				parents[i] += mod;

			dp[i] += dp[i - 1];
			dp[i] %= mod;
			if (dp[i] < 0)
				dp[i] += mod;
			dp[i] += parents[i];
			dp[i] %= mod;

			if (i + forget <= n) {
				dp[i + forget] -= parents[i];
				dp[i + forget] %= mod;
			}

			if (i + delay <= n) {
				parents[i + delay] += parents[i];
				parents[i + delay] %= mod;
			}

			if (i + forget <= n) {
				parents[i + forget] -= parents[i];
				parents[i + forget] %= mod;
			}

		}

		return (int) dp[n];
	}
}
