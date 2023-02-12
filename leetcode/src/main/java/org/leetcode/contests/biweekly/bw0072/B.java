package org.leetcode.contests.biweekly.bw0072;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public long[] sumOfThree(long num) {
		if (num % 3 != 0)
			return new long[0];
		long x = num / 3 - 1;
		return new long[] { x, x + 1, x + 2 };
	}
}
