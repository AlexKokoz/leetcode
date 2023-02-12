package org.leetcode.contests.biweekly.bw0048;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	Integer[][] memo;
	int[][] gcd;
	int ans;

	public int maxScore(int[] nums) {
		int n = nums.length;
		memo = new Integer[1 << n][n / 2 + 1];
		gcd = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				gcd[i][j] = gcd[j][i] = gcd(nums[i], nums[j]);
			}
		}
		dp((1 << n) - 1, n, nums, n / 2);
		return ans;
	}

	int dp(int b, int n, int[] nums, int round) {
		if (b == 0)
			return 0;
		if (memo[b][round] != null)
			return memo[b][round];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || !(b << ~i < 0 && b << ~j < 0))
					continue;
				int nb = (b & ~(1 << i)) & ~(1 << j);
				ans = Math.max(ans, round * gcd[i][j] + dp(nb, n, nums, round - 1));
			}
		}
		this.ans = Math.max(this.ans, ans);
		return memo[b][round] = ans;
	}

	static int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}
