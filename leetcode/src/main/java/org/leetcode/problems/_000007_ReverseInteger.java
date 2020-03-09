package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000007_ReverseInteger {
	public int reverse(int x) {
		boolean minus = x < 0 ? true : false;
		x = Math.abs(x);
		long ans = 0;
		while (x > 0) {
			ans = ans * 10 + (x % 10);
			x /= 10;
		}
		if (minus)
			ans = -ans;
		if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
			return 0;
		return (int) ans;
	}
}
