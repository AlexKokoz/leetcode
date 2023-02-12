package org.leetcode.contests.weekly.w0319;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int maxPalindromes(String s, int k) {
		int n = s.length();
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
			int l = i;
			int r = i;
			while (0 <= l && r < n && s.charAt(l) == s.charAt(r)) {
				if (r - l + 1 >= k) {
					dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
				}
				l--;
				r++;
			}
			if (i > 0) {
				l = i - 1;
				r = i;
				while (0 <= l && r < n && s.charAt(l) == s.charAt(r)) {
					if (r - l + 1 >= k) {
						dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
					}
					l--;
					r++;
				}
			}
		}
		return dp[n];
	}
}
