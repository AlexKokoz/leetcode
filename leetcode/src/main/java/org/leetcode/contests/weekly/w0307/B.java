package org.leetcode.contests.weekly.w0307;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public String largestPalindromic(String num) {
		int[] count = new int[10];
		int n = num.length();
		for (int i = 0; i < n; i++) {
			count[num.charAt(i) - '0']++;
		}
		int maxSingle = -1;
		StringBuilder pref = new StringBuilder();
		for (int d = 9; d >= 0; d--) {
			if (pref.length() == 0 && d == 0) {
				if (maxSingle == -1) {
					return "0";
				} else {
					return Integer.toString(maxSingle);
				}
			}
			for (int i = 0; i < count[d] / 2; i++) {
				pref.append(d);
			}
			if (count[d] % 2 == 1) {
				maxSingle = Math.max(maxSingle, d);
			}
		}
		StringBuilder suff = new StringBuilder(pref).reverse();
		if (maxSingle != -1) {
			pref.append(maxSingle);
		}
		pref.append(suff);
		return pref.toString();
	}
}
