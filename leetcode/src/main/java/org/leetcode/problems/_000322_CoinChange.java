package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000322_CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		Arrays.sort(coins);
		final int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		for (int x : coins) {
			if (x < amount)
				dp[x] = 1;
			else if (x == amount)
				return 1;
		}
		for (int ia = 1; ia <= amount; ia++) {
			for (int coin : coins) {
				if (ia - coin < 0)
					break;
				dp[ia] = Math.min(dp[ia], dp[ia - coin] + 1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
