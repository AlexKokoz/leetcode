package org.leetcode.contests.weekly.w0299;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int countHousePlacements(int n) {
		long mod = 1000000007;
		long[] dp = { 1, 0, 0, 0 }; // 00, 01, 10, 11
		for (int i = 0; i < n; i++) {
			long[] ndp = new long[4];
			ndp[0] = dp[0] + dp[1] + dp[2] + dp[3];
			ndp[0] %= mod;
			ndp[1] = dp[0] + dp[2];
			ndp[1] %= mod;
			ndp[2] = dp[0] + dp[1];
			ndp[2] %= mod;
			ndp[3] = dp[0];
			ndp[3] %= mod;
			dp = ndp;
		}
		long ans = 0;
		for (long x : dp) {
			ans += x;
			ans %= mod;
		}
		return (int) ans;

	}
}
