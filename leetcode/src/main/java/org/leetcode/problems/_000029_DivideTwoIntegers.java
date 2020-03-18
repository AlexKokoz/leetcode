package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000029_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		boolean minus = dividend < 0 ^ divisor < 0 ? true : false;
		long ans = 0;

		long dividendL = dividend;
		dividendL = Math.abs(dividendL);
		long divisorL = divisor;
		divisorL = Math.abs(divisorL);
		for (int i = 31; i >= 0; i--) {
			if ((divisorL << i) <= dividendL) {
				ans |= (1L << i); // or +=
				dividendL -= (divisorL << i);
			}
		}
		if (minus)
			ans = -ans;
		if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		return (int) ans;
	}
}
