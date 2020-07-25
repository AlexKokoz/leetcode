package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000087_ScrambleString {
	public boolean isScramble(String s1, String s2) {
		return helper(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1);
	}

	boolean helper(String s1, int l1, int r1, String s2, int l2, int r2) {

		if (r1 - l1 != r2 - l2)
			return false;

		int n = r1 - l1 + 1;

		if (equal(s1, l1, s2, l2, n))
			return true;

		int[] freq = new int[26];
		for (int i = 0; i < n; i++) {
			freq[s1.charAt(l1 + i) - 'a']++;
			freq[s2.charAt(l2 + i) - 'a']--;
		}
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0)
				return false;
		}

		for (int i = 0; i < n - 1; i++) {
			if (
					(
							helper(s1, l1, l1 + i, s2, l2, l2 + i) && 
							helper(s1, l1 + i + 1, r1, s2, l2 + i + 1, r2)
					)
					|| 
					(
							helper(s1, l1, l1 + i, s2, r2 - i, r2) && 
							helper(s1, l1 + i + 1, r1, s2, l2, r2 - i - 1)
					)
			    )
				return true;
		}
		return false;
	}

	boolean equal(String s1, int l1, String s2, int l2, int n) {
		for (int i = 0; i < n; i++) {
			if (s1.charAt(l1 + i) != s2.charAt(l2 + i))
				return false;
		}
		return true;
	}
}
