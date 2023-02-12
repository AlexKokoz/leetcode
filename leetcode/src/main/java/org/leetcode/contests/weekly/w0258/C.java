package org.leetcode.contests.weekly.w0258;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maxProduct(String s) {
		int n = s.length();
		boolean[] pal = new boolean[1 << n];
		pal[0] = true;
		for (int i = 1; i < 1 << n; i++) {
			pal[i] = pal(s, i);
		}
		int max = 0;
		for (int m1 = 1; m1 < (1 << n - 1); m1++) {
			if (!pal[m1])
				continue;
			int rem = ((1 << n) - 1) ^ m1;
			for (int m2 = rem; m2 > 0; m2 = (m2 - 1) & rem) {
				if (pal[m2]) {
					max = Math.max(max, Integer.bitCount(m1) * Integer.bitCount(m2));
				}
			}
		}
		return max;
	}

	boolean pal(String s, int i) {
		StringBuilder sb = new StringBuilder();
		for (int b = 0; b < s.length(); b++) {
			if (i << ~b < 0) {
				sb.append(s.charAt(b));
			}
		}
		int l = 0;
		int r = sb.length();
		while (l < r) {
			if (sb.charAt(l) != sb.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
