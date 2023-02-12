package org.leetcode.contests.biweekly.bw0094;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int minimizeSet(int div1, int div2, int uniq1, int uniq2) {
		long ans = 1;
		long lo = 1;
		long hi = Integer.MAX_VALUE;
		while (lo <= hi) {
			long mi = lo + (hi - lo) / 2;
			if (ok(mi, div1, div2, uniq1, uniq2)) {
				ans = mi;
				hi = mi - 1;
			} else {
				lo = mi + 1;
			}
		}
		return (int) ans;
	}

	boolean ok(long cand, long div1, long div2, long uniq1, long uniq2) {
		long occs1 = cand / div1;
		long occs2 = cand / div2;

		long lcm = lcm(div1, div2);
		long occslcm = cand / lcm;

		long free1 = cand - occs1;
		long free2 = cand - occs2;

		long totalUniqFree = occs1 + occs2 - 2 * occslcm + (cand - (occs1 + occs2 - 2 * occslcm + occslcm));
		return free1 >= uniq1 && free2 >= uniq2 && uniq1 + uniq2 <= totalUniqFree;

	}

	static long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
}
