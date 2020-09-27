package org.leetcode.contests.weekly.w0205;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001576_ReplaceAllQuestionmarksToAvoidConsecutiveRepeatingCharacters {
	public String modifyString(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c != '?')
				continue;
			char prev = i > 0 ? sb.charAt(i - 1) : '\0';
			char next = i < sb.length() - 1 ? sb.charAt(i + 1) : '\0';
			if (prev != 'a' && next != 'a')
				sb.setCharAt(i, 'a');
			else if (prev != 'b' && next != 'b')
				sb.setCharAt(i, 'b');
			else if (prev != 'c' && next != 'c')
				sb.setCharAt(i, 'c');
		}
		return sb.toString();
	}
}
