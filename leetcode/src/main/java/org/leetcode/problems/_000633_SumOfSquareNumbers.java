package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000633_SumOfSquareNumbers {
	public boolean judgeSquareSum(int c) {
		for (int a = 0; a * a <= c / 2; a++) {
			long target = c - a * a;
			if (target == 1) {
				return true;
			}
			long lo = 0;
			long hi = target >>> 1;
			while (lo <= hi) {
				long mi = lo + (hi - lo >>> 1);
				long prod = mi * mi;
				if (prod < target) {
					lo = mi + 1;
				} else if (prod > target) {
					hi = mi - 1;
				} else {
					return true;
				}
			}
		}
		return false;
	}
}
