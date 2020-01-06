package org.leetcode.contests.weekly.w0170;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001309_DecryptStringFromAlphabetToIntegerMapping {
	public String freqAlphabets(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c;
			if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
				c = (char) ('a' - 1 + Integer.parseInt(s.substring(i, i + 2)));
				i += 2;
			} else {
				c = (char) ('a' - 1 + Character.getNumericValue(s.charAt(i)));
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
