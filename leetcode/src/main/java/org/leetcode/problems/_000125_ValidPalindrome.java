package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000125_ValidPalindrome {
	public boolean isPalindrome(String s) {
		int n = s.length();
		int lo = 0;
		int hi = n - 1;
		while (lo < hi) {
			while (lo < n && !isAlphanumeric(s.charAt(lo)))
				lo++;
			while (hi >= 0 && !isAlphanumeric(s.charAt(hi)))
				hi--;
			if (lo >= hi)
				break;
			if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi)))
				return false;
			hi--;
			lo++;
		}

		return true;
	}

	static boolean isAlphanumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}
}
