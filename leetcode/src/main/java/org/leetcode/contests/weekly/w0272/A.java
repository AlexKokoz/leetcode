package org.leetcode.contests.weekly.w0272;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String firstPalindrome(String[] words) {
		outer: for (String w : words) {
			int l = 0;
			int r = w.length() - 1;
			while (l < r) {
				if (w.charAt(l) != w.charAt(r))
					continue outer;
				l++;
				r--;
			}
			return w;
		}
		return "";
	}
}
