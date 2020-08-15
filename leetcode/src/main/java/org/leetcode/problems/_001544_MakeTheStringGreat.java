package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001544_MakeTheStringGreat {
	public String makeGood(String s) {
		StringBuilder sb = new StringBuilder(s);
		boolean change = true;
		while (change) {
			StringBuilder nsb = new StringBuilder();
			change = false;
			for (int i = 0; i < sb.length(); i++) {
				char c1 = sb.charAt(i);
				if (i == sb.length() - 1) {
					nsb.append(c1);
					continue;
				}
				char c2 = sb.charAt(i + 1);
				if (c1 != c2 && Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
					i++;
					change = true;
				} else {
					nsb.append(c1);
				}
			}
			sb = nsb;
		}
		return sb.toString();

	}
}
