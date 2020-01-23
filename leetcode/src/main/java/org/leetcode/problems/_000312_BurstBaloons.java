package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000312_BurstBaloons {

	/*
	 * For an interval [L, R], for every inner index k: L <= k <= R calculate max:
	 * nums[L - 1]---cost[L..k - 1]---nums[k]---cost[k + 1..R]---nums[R + 1]
	 * 
	 */
	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];
		for (int len = 1; len <= n; len++) {
			for (int L = 0; L <= n - len; L++) {
				int R = L + len - 1;
				for (int k = L; k <= R; k++) {
					int cost = get(nums, k) * get(nums, L - 1) * get(nums, R + 1) + (k == 0 ? 0 : dp[L][k - 1])
							+ (k == n - 1 ? 0 : dp[k + 1][R]);
					dp[L][R] = Math.max(dp[L][R], cost);
				}
			}
		}
		return n == 0 ? 0 : dp[0][n - 1];
	}

	int get(int[] nums, int i) {
		if (i < 0 || i >= nums.length)
			return 1;
		return nums[i];
	}
}
