package org.leetcode.contests.biweekly.bw0017;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001316_DistinctEchoSubstrings {
	public int distinctEchoSubstrings(String text) {
		int n = text.length();
		Set<String> found = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String substr = text.substring(i);
			int[] z = buildZ(substr);
			for (int j = 1; j < z.length; j++)
				if (z[j] >= j)
					found.add(substr.substring(0, 2 * j));
		}
		return found.size();
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
	static int[] buildZ(String s) {
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
