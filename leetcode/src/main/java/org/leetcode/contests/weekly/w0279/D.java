package org.leetcode.contests.weekly.w0279;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int minimumTime(String s) {
		int n = s.length();
		int ans = n;
		char[] cs = s.toCharArray();
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			dp[i + 1] = Math.min(i + 1, dp[i] + (cs[i] == '1' ? 2 : 0));
		}
		for (int i = 0; i <= n; i++) {
			ans = Math.min(ans, dp[i] + n - i);
		}
		return ans;
	}
}
