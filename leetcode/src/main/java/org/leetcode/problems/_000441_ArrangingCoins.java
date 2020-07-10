package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000441_ArrangingCoins {
	public int arrangeCoins(int n) {
		long lo = 1;
		long hi = n / 2 + 1;
		while (lo <= hi) {
			long mi = lo + (hi - lo >> 1);
			long cur = mi * (mi + 1) / 2;
			if (cur > n)
				hi = mi - 1;
			else if (cur < n)
				lo = mi + 1;
			else
				return (int) mi;
		}
		return (int) hi;
	}
}
