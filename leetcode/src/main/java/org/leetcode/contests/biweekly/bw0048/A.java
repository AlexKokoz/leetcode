package org.leetcode.contests.biweekly.bw0048;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int secondHighest(String s) {
		int max = -1;
		int max2 = -1;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				int d = c - '0';
				if (d > max) {
					max2 = max;
					max = d;
				} else if (d == max) {
				} else if (d > max2) {
					max2 = d;
				}
			}
		}
		return max2;
	}
}
