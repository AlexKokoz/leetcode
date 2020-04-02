package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000434_NumberOfSegmentsInAString {
	public int countSegments(String s) {
		s = s.trim();
		char prev = '\0';
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == ' ' && cur != prev)
				count++;
			prev = cur;
		}
		return count + (prev == '\0' ? 0 : 1);
	}
}
