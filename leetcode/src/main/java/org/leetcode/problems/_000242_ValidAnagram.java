package org.leetcode.problems;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000242_ValidAnagram {
	public boolean isAnagram(String s1, String s2) {
		final int n1 = s1.length();
		final int n2 = s2.length();
		if (n1 != n2)
			return false;
		final int[] f = new int[26];
		for (int i = 0; i < n1; i++) {
			final char c = s1.charAt(i);
			f[c - 'a']++;
		}
		for (int i = 0; i < n1; i++) {
			final char c = s2.charAt(i);
			f[c - 'a']--;
			if (f[c - 'a'] < 0)
				return false;
		}
		for (int x : f) {
			if (x > 0)
				return false;
		}
		return true;
	}
}
