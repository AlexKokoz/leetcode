package org.leetcode.contests.weekly.w0305;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public int longestIdealString(String s, int k) {
		int ans = 0;
		int[] dp = new int[26];
		Arrays.fill(dp, -1);
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int cur = s.charAt(i) - 'a';
			int cand = 1;
			for (int prev = Math.max(0, cur - k); prev <= Math.min(25, cur + k); prev++) {
				if (dp[prev] != -1)
					cand = Math.max(cand, dp[prev] + 1);
			}
			dp[cur] = Math.max(dp[cur], cand);
		}
		for (int cand : dp) {
			ans = Math.max(ans, cand);
		}
		return ans;

	}

}
