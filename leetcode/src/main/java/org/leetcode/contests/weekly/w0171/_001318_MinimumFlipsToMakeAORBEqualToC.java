package org.leetcode.contests.weekly.w0171;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001318_MinimumFlipsToMakeAORBEqualToC {
	public int minFlips(int a, int b, int c) {
		int max = Math.max(a, Math.max(b, c));
		int min = 0;
		while (max > 0) {
			int act = (a & 1) | (b & 1);
			int exp = (c & 1);
			if (act != exp) {
				if (exp == 1)
					min++;
				else if (exp == 0) {
					if ((a & 1) == 1)
						min++;
					if ((b & 1) == 1)
						min++;
				}
			}
			a >>= 1;
			b >>= 1;
			c >>= 1;
			max >>= 1;
		}
		return min;
	}
}
