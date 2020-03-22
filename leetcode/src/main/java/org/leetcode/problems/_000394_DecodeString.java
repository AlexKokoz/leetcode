package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000394_DecodeString {
	int i = 0;

	public String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		while (i < s.length()) {
			int k = parseK(s);
			String sub = parseText(s);
			for (int i = 0; i < k; i++)
				sb.append(sub);
		}
		return sb.toString();
	}

	int parseK(String s) {
		if (i >= s.length())
			return 0;
		if (!isDigit(s.charAt(i)))
			return 1;
		int k = 0;
		while (s.charAt(i) != '[')
			k = k * 10 + (s.charAt(i++) - '0');
		i++; // skip '['
		return k;
	}

	String parseText(String s) {
		StringBuilder sb = new StringBuilder();
		while (i < s.length() && s.charAt(i) != ']') {
			char c = s.charAt(i);
			if (isDigit(c)) {
				int k = parseK(s);
				String sub = parseText(s);
				for (int i = 0; i < k; i++)
					sb.append(sub);
			} else {
				sb.append(c);
				i++;
			}
		}
		i++; // skip ']'
		return sb.toString();
	}

	boolean isDigit(char c) {
		return '0' <= c && c <= '9';
	}
}
