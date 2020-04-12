package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001281_SubtractTheProductAndSumOfDigitsOfAnInteger {
	public int subtractProductAndSum(int n) {
		int prod = 1;
		int sum = 0;
		while(n > 0) {
			int d = n % 10;
			prod *= d;
			sum += d;
			n /= 10;
		}
		return prod - sum;
	}
}
