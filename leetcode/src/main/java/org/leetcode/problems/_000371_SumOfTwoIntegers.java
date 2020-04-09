package org.leetcode.problems;

public class _000371_SumOfTwoIntegers {
	public int getSum(int a, int b) {
		return 2 * (a & b) + (a ^ b);
	}
}
