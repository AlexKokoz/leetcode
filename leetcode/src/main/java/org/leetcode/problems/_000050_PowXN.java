package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000050_PowXN {
	public double myPow(double x, int n) {
		boolean minus = n < 0 ? true : false;
		long nl = n < 0 ? -(long) n : n;
		double ans = pow(x, (long) nl);
		return minus ? 1 / ans : ans;
	}

	double pow(double x, long n) {
		if (n == 0)
			return 1;
		if ((n & 1) == 0)
			return pow(x * x, n >> 1);
		else
			return x * pow(x * x, n >> 1);
	}
}
