package org.leetcode.contests.biweekly.bw0086;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public boolean isStrictlyPalindromic(int n) {
		for (int b = 2; b <= n - 2; b++) {
			StringBuilder sb = new StringBuilder();
			int now = n;
			while (now > 0) {
				sb.append(now % b);
				now /= b;
			}
			if (sb.length() == 0)
				sb.append(0);
			if (!pal(sb.toString()))
				return false;
		}
		return true;
	}

	boolean pal(String s) {
		int n = s.length();
		int l = 0;
		int r = n - 1;
		while (l < r && s.charAt(l) == s.charAt(r)) {
			l++;
			r--;
		}
		return l >= r;
	}
}
