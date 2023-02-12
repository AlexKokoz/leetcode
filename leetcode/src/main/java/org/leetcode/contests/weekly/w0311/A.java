package org.leetcode.contests.weekly.w0311;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int smallestEvenMultiple(int n) {
		return  n % 2 == 0 ? n : (2 * n);
	}
}
