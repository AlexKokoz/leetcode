package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000008_StringToInteger {
	public int myAtoi(String str) {
		str = str.trim();
		int sign = 1;
		long ans = 0;
		for (int i = 0; i < str.length(); i++) {			
			char c = str.charAt(i);
			if (c == '-')
				if (i == 0)
					sign = -1;
				else
					break;
			else if (c == '+')
				if (i != 0)
					break;
				else
					continue;
			else if ('0' <= c && c <= '9')
				ans = ans * 10 + sign * (c - '0');
			else
				break;
			if (ans > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (ans < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) ans;
	}
}
