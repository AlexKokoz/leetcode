package org.leetcode.contests.biweekly.bw0030;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001510_StoneGameIV {

	public boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 1; j * j <= i; j++) {
				if (!dp[i - j * j]) {
					dp[i] = true;
					break;
				}
			}
		return dp[n];
	}
}
