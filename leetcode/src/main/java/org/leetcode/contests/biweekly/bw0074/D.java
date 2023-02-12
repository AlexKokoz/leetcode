package org.leetcode.contests.biweekly.bw0074;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
		int n = floor.length();
		int ans = 0;
		int[] cum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			cum[i + 1] = cum[i] + (floor.charAt(i) == '1' ? 1 : 0);
		}
		int[][] dp = new int[numCarpets + 1][n + 1];
		for (int i = 0; i < n; i++) {
			for (int carpet = 1; carpet <= numCarpets; carpet++) {
				int prev = Math.max(-1, i - carpetLen);
				dp[carpet][i + 1] = Math.max(dp[carpet][i],
						dp[carpet - 1][prev + 1] + cum[i + 1] - cum[prev + 1]);
				ans = Math.max(ans, Math.max(dp[carpet][i + 1], dp[carpet][i]));
			}
		}

		return cum[n] - ans;
	}
}
