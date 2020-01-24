package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000005_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		final int n = s.length();
		String max = "";
		for (int i = 0; i < n; i++) {

			// check odd palindromes
			String odd = getPalindrome(i, i, s);
			max = (odd.length() > max.length() ? odd : max);

			// check even palindromes
			String even = (i < n - 1 && s.charAt(i) == s.charAt(i + 1) ? getPalindrome(i, i + 1, s) : "");
			max = (even.length() > max.length() ? even : max);

		}

		return max;
	}

	// Expand palindrome centered at c1, c2
	// For odd palindromes: c1 == c2
	static String getPalindrome(int c1, int c2, String s) {
		final int n = s.length();
		int j = 0;
		while (c1 - j >= 0 && c2 + j < n && s.charAt(c1 - j) == s.charAt(c2 + j))
			j++;
		return s.substring(c1 - j + 1, c2 + j);
	}
}
