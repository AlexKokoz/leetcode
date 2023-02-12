package org.leetcode.contests.biweekly.bw0081;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int distinctSequences(int n) {
		if (n == 1)
			return 6;

		long mod = 1000000007;
		long ans = 0;
		int[][] good = { {}, { 2, 3, 4, 5, 6 }, { 1, 3, 5 }, { 1, 2, 4, 5 }, { 1, 3, 5 }, { 1, 2, 3, 4, 6 },
				{ 1, 5 } };
		long[][][] dp = new long[7][7][7];
		for (int i = 1; i <= 6; i++) {
			dp[0][0][i] = 1;
		}
		for (int turn = 2; turn <= n; turn++) {
			long[][][] ndp = new long[7][7][7];
			for (int cur = 1; cur < 7; cur++) {
				for (int prev3 = 0; prev3 < 7; prev3++) {
					for (int prev1 : good[cur]) {
						for (int prev2 = 0; prev2 < 7; prev2++) {
							if (prev2 == cur)
								continue;
							ndp[prev2][prev1][cur] += dp[prev3][prev2][prev1];
							ndp[prev2][prev1][cur] %= mod;
						}
					}
				}
			}

			dp = ndp;
		}
		for (long[][] a : dp) {
			for (long[] b : a) {
				for (long x : b) {
					ans += x;
					ans %= mod;
				}
			}
		}
		return (int) ans;
	}
}
