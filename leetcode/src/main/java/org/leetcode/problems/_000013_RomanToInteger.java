package org.leetcode.problems;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000013_RomanToInteger {

	public int romanToInt(String s) {

		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			final int cur = romanToInteger(s.charAt(i));
			if (i < s.length() - 1) {
				final int next = romanToInteger(s.charAt(i + 1));
				if (cur < next) {
					ans += next - cur;
					i++;
				} else
					ans += cur;
			} else
				ans += cur;
		}

		return ans;
	}

	static int romanToInteger(char roman) {
		final int I = 1;
		final int V = 5;
		final int X = 10;
		final int L = 50;
		final int C = 100;
		final int D = 500;
		final int M = 1000;

		switch (roman) {
		case 'I':
			return I;
		case 'V':
			return V;
		case 'X':
			return X;
		case 'L':
			return L;
		case 'C':
			return C;
		case 'D':
			return D;
		case 'M':
			return M;
		default:
			throw new IllegalArgumentException();
		}
	}

}
