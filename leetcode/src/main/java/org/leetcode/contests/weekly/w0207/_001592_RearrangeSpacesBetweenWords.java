package org.leetcode.contests.weekly.w0207;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001592_RearrangeSpacesBetweenWords {
	public String reorderSpaces(String text) {
		StringBuilder sb = new StringBuilder();
		int spaces = 0;
		for (int i = 0; i < text.length(); i++)
			if (text.charAt(i) == ' ')
				spaces++;
		text = text.trim();
		text = text.replaceAll("\\s+", " ");
		String[] words = text.split(" ");
		int foreach = words.length == 1 ? 0 : spaces / (words.length - 1);
		int leftovers = words.length == 1 ? spaces : spaces % (words.length - 1);
		for (int i = 0; i < words.length; i++) {
			sb.append(words[i]);
			if (i < words.length - 1)
				for (int j = 0; j < foreach; j++)
					sb.append(" ");
		}
		for (int i = 0; i < leftovers; i++)
			sb.append(" ");
		return sb.toString();
	}
}
