package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001137_NthTribonacciNumber {
	public int tribonacci(int n) {
		int t0 = 0;
		int t1 = 1;
		int t2 = 1;
		switch (n) {
		case 0:
			return t0;
		case 1:
			return t1;
		case 2:
			return t2;
		}
		int tn = 0;
		for (int i = 3; i <= n; i++) {
			tn = t0 + t1 + t2;
			t0 = t1;
			t1 = t2;
			t2 = tn;
		}
		return tn;
	}
}
