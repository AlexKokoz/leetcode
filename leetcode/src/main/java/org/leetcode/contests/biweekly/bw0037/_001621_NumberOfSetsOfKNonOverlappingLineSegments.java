package org.leetcode.contests.biweekly.bw0037;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001621_NumberOfSetsOfKNonOverlappingLineSegments {
	public int numberOfSets(int n, int k) {
		long mod = 1000000007;
		long ans = 0;
		long[][] dp = new long[k + 1][n];
		dp[0][0] = 1;
		for (int r = 1; r < dp.length; r++) {
			long sum = 0;
			for (int c = 1; c < dp[0].length; c++) {
				sum += dp[r - 1][c - 1];
				if (sum >= mod) sum -= mod;
				// ways(choose r segments from interval c - 1) + sum(ways(r - 1 segments from sizes[1.. c))
				dp[r][c] = dp[r][c - 1] + sum; 
				if (dp[r][c] >= mod) dp[r][c] -= mod;
			}
		}
		for (long x : dp[k]) {
			ans += x;
			if (ans >= mod) ans -= mod;
		}
		return (int) ans;
	}
}
