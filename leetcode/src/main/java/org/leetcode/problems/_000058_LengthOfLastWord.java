package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000058_LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		if (s.length() == 0) return 0;
		int i;
		for (i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; i--);
		return s.length() - 1 - i;
	}
}
