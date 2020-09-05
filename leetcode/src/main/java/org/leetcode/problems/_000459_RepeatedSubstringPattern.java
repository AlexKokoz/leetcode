package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000459_RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int[] z = buildZ(s);
		for (int i = n - 1; i > 0; i--) {
			if (n - i != z[i])
				continue;
			int j = i;
			while (j > 0 && z[j] >= z[i])
				j -= z[i];
			if (j == 0)
				return true;
		}
		return false;
	}

	/*
	 * Builds the z-algorithm prefix length table for a given string S of length N.
	 * 
	 * Value z[i] equals to the max length of common prefix between S[0..N-1] and
	 * S[i..N-1].
	 * 
	 * Time Complexity: O[N]
	 * 
	 */
	public static int[] buildZ(String s) {
		final int n = s.length();
		int[] z = new int[n];
		int l = 0;
		int r = 0;
		for (int i = 1; i < n; i++) {
			if (i > r) {
				l = r = i;
				while (r < n && s.charAt(r) == s.charAt(r - l))
					r++;
				z[i] = r - l;
				r--;
			} else {
				int k = i - l;
				if (z[k] < r - i + 1)
					z[i] = z[k];
				else {
					l = i;
					while (r < n && s.charAt(r) == s.charAt(r - l))
						r++;
					z[i] = r - l;
					r--;
				}
			}
		}
		return z;
	}
}
