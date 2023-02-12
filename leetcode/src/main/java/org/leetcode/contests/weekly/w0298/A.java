package org.leetcode.contests.weekly.w0298;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String greatestLetter(String s) {
		boolean[] l = new boolean[26];
		boolean[] u = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLowerCase(c)) {
				l[c - 'a'] = true;
			} else {
				u[c - 'A'] = true;
			}
		}
		for (int i = 25; i >= 0; i--) {
			if (l[i] && u[i])
				return String.valueOf((char) (i + 'A'));
		}
		return "";
	}
}
