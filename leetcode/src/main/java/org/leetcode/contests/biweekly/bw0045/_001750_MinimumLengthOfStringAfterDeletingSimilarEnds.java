package org.leetcode.contests.biweekly.bw0045;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001750_MinimumLengthOfStringAfterDeletingSimilarEnds {
	public int minimumLength(String s) {
		int n = s.length();
		int lo = 0;
		int hi = n - 1;
		while (lo < hi && s.charAt(lo) == s.charAt(hi)) {
			while (++lo < hi && s.charAt(lo) == s.charAt(lo - 1))
				;
			while (lo < --hi && s.charAt(hi) == s.charAt(hi + 1))
				;
		}
		return Math.max(0, hi - lo + 1);
	}
}
