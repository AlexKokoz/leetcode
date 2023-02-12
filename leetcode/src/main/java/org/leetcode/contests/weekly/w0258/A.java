package org.leetcode.contests.weekly.w0258;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String reversePrefix(String word, char ch) {
		int n = word.length();
		int i = 0;
		while (i < n && word.charAt(i) != ch)
			i++;
		if (i < n) {
			StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
			sb.reverse();
			sb.append(word.substring(i + 1, n));
			return sb.toString();
		} else {
			return word;
		}

	}
}
