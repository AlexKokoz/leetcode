package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000647_PalindromicSubstrings {

	/*
	 * Time Complexity: O(N^2)
	 * Space Complexity: O(1) 
	 */
	public int countSubstrings(String s) {
		int n = s.length();
		int count = n;
		for (int i = 0; i < n; i++) {
			int len = 0;
			while (isPalindrome(s, i, i, len++))
				count++;
			len = 0;
			while (isPalindrome(s, i, i + 1, len++))
				count++;
		}
		return count;
	}

	boolean isPalindrome(String s, int c1, int c2, int len) {
		int l = c1 - len;
		int r = c2 + len;
		return l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r);
	}
	
	
	/*
	 * Time Complexity: O(N^2)
	 * Space Complexity: O(N^2) 
	 */
	public int countSubstrings2(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++)
			dp[i][i] = true;
		int count = n;
		for (int len = 2; len <= n; len++) {
			for (int l = 0; l <= n - len; l++) {
				int r = l + len - 1;
				char c1 = s.charAt(l);
				char c2 = s.charAt(r);
				if (c1 == c2 && (r > l + 1 ? dp[l + 1][r - 1] : true)) {
					dp[l][r] = true;
					count++;
				}

			}
		}
		return count;
	}

}
