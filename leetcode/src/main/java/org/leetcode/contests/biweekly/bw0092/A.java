package org.leetcode.contests.biweekly.bw0092;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int numberOfCuts(int n) {
		if (n == 1)
			return 0;
		if (n % 2 == 0)
			return n / 2;
		return n;
	}
}
