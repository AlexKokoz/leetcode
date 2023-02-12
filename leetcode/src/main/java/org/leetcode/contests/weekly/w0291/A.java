package org.leetcode.contests.weekly.w0291;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String removeDigit(String s, char digit) {
		int n = s.length();
		String ans = null;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i - 1) == digit && s.charAt(i) > digit) {
				ans = s.substring(0, i - 1) + s.substring(i, n);
				return ans;
			}
		}
		int pos = s.lastIndexOf(digit);
		return s.substring(0, pos) + s.substring(pos + 1, n);
	}
}
