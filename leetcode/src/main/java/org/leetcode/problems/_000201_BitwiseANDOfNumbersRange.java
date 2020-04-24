package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000201_BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
		// check if numbers are equal
		if (m == n)
			return m;

		// check if m = 0
		int and = m & n;
		if (and == 0)
			return 0;

		// check if n has at least one higher set bit that m
		int mm = m;
		int nn = n;
		while (mm != 0 && nn != 0) {
			nn >>= 1;
			mm >>= 1;
		}
		if (nn == 0 ^ mm == 0)
			return 0;

		// traverse the range
		for (int i = m + 1; i <= n - 1; i++)
			and &= i;

		return and;
	}
}
