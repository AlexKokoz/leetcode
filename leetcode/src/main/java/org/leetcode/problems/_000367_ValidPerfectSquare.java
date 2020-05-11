package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000367_ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		long lo = 0;
		long hi = num / 2;
		while (lo <= hi) {
			long mi = lo + (hi - lo >>> 1);
			long prod = mi * mi;
			if (prod < num) {
				lo = mi + 1;
			} else if (num < prod) {
				hi = mi - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
