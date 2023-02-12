package org.leetcode.contests.weekly.w0321;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int pivotInteger(int n) {
		int lo = 1;
		int hi = n;

		while (lo <= hi) {
			int mi = lo + (hi - lo) / 2;
			int left = mi * (mi + 1) / 2;
			int right = n * (n + 1) / 2 - (mi - 1) * (mi) / 2;
			if (left < right) {
				lo = mi + 1;
			} else if (left > right) {
				hi = mi - 1;
			} else {
				return mi;
			}
		}
		return -1;
	}
}
