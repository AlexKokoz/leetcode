package org.leetcode.contests.weekly.w0300;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String decodeMessage(String key, String message) {
		char[] sub = new char[26];
		int nk = key.length();
		boolean[] seen = new boolean[26];
		char c = 'a';
		for (int i = 0; i < nk; i++) {
			if (key.charAt(i) == ' ')
				continue;
			int id = key.charAt(i) - 'a';
			if (seen[id])
				continue;
			seen[id] = true;
			sub[id] = c;
			c++;
		}
		StringBuilder sb = new StringBuilder();
		int nm = message.length();
		for (int i = 0; i < nm; i++) {
			if (message.charAt(i) == ' ')
				sb.append(' ');
			else
				sb.append(sub[message.charAt(i) - 'a']);
		}
		return sb.toString();

	}
}
