package org.leetcode.contests.biweekly.bw0034;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001575_CountAllPossibleRoutes {
	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		int n = locations.length;
		long mod = 1000000007;
		long[][] dp = new long[fuel + 1][n];
		dp[0][start] = 1;
		for (int f = 0; f <= fuel; f++) {
			for (int src = 0; src < n; src++) {
				for (int dest = 0; dest < n; dest++) {
					int dist = Math.abs(locations[src] - locations[dest]);
					if (src == dest || f + dist > fuel)
						continue;
					dp[f + dist][dest] += dp[f][src];
					if (dp[f + dist][dest] >= mod)
						dp[f + dist][dest] -= mod;
				}
			}
		}
		long ans = 0;
		for (int f = 0; f <= fuel; f++) {
			ans += dp[f][finish];
			if (ans >= mod)
				ans -= mod;
		}
		return (int) ans;
	}
}
