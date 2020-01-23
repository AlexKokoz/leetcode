package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000375_GuessNumberHigherOrLowerII {
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n + 1];
		for (int len = 1; len <= n; len++) {
			for (int l = 1; l <= n - len + 1; l++) {
				int r = l + len - 1;
				switch (len) {
				case 1:
					dp[l][r] = 0; // redundant; array already initialized as such
					continue;
				case 2:
					dp[l][r] = l; // min of {l, r}
					continue;
				case 3:
					dp[l][r] = l + 1; // middle number; ie dp[6][8] = 7
					continue;
				}
				dp[l][r] = Integer.MAX_VALUE;
				for (int k = l + 1; k < r; k++) {
					int leftCost = dp[l][k - 1] + k;
					int rightCost = k + dp[k + 1][r];
					dp[l][r] = Math.min(dp[l][r], Math.max(leftCost, rightCost));
					if (leftCost > rightCost)
						break;
				}
			}
		}
		return dp[1][n];
	}
}
