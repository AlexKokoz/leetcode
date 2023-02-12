package org.leetcode.contests.biweekly.bw0091;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int countGoodStrings(int low, int high, int zero, int one) {
		long mod = 1000000007;
		long[] dp = new long[high + 1];
		dp[0] = 1;
		for (int i = 0; i < high; i++) {
			if (i + zero <= high) {
				dp[i + zero] += dp[i];
				dp[i + zero] %= mod;
			}
			if (i + one <= high) {
				dp[i + one] += dp[i];
				dp[i + one] %= mod;
			}
		}
		long ans = 0;
		for (int i = low; i <= high; i++) {
			ans += dp[i];
			ans %= mod;
		}
		return (int) ans;
	}
}
