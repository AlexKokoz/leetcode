package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000151_ReverseWordsInAString {
	public String reverseWords(String s) {
		s = s.trim();
		String[] words = s.split("\\s+");
		final StringBuilder sb = new StringBuilder();
		String sep = "";
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(sep);
			sb.append(words[i]);
			sep = " ";
		}
		return sb.toString();
	}
}
