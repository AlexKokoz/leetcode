package org.leetcode.contests.biweekly.bw0075;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long sumScores(String s) {
		int n = s.length();
		int[] z = z(s);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += z[i];
		}
		return ans;
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
	public static int[] z(String s) {
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
		z[0] = n;
		return z;
	}
}
