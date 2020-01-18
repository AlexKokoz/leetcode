package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001220_CountVowelsPermutation {
	public int countVowelPermutation(int n) {
		int mod = 1000000007;
		int[] dp = new int[5]; // a, e, i, o, u
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			int[] ndp = new int[5];
			for (int j = 0; j < 5; j++) {
				if (dp[j] == 0)
					continue;
				switch (j) {
				case 0:
					ndp[1] = (ndp[1] + dp[j]) % mod;
					break;
				case 1:
					ndp[0] = (ndp[0] + dp[j]) % mod;
					ndp[2] = (ndp[2] + dp[j]) % mod;
					break;
				case 2:
					ndp[0] = (ndp[0] + dp[j]) % mod;
					ndp[1] = (ndp[1] + dp[j]) % mod;
					ndp[3] = (ndp[3] + dp[j]) % mod;
					ndp[4] = (ndp[4] + dp[j]) % mod;
					break;
				case 3:
					ndp[2] = (ndp[2] + dp[j]) % mod;
					ndp[4] = (ndp[4] + dp[j]) % mod;
					break;
				case 4:
					ndp[0] = (ndp[0] + dp[j]) % mod;
					break;
				default:
					throw new IllegalArgumentException();
				}
			}
			dp = ndp;
		}
		int ans = 0;
		for (int x : dp)
			ans = (ans + x) % mod;
		return ans;
	}
}
