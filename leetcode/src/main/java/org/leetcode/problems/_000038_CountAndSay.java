package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000038_CountAndSay {
	public String countAndSay(int n) {
		String s = "1";
		for (int i = 2; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				count++;
				if (j == s.length() - 1 || s.charAt(j) != s.charAt(j + 1)) {
					sb.append(count);
					sb.append(s.charAt(j));
					count = 0;
				}
			}
			s = sb.toString();
		}
		return s;
	}
}
