package org.leetcode.contests.weekly.w0193;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001481_MinimumNumberOfDaysToMakeMBouquets {
	public int minDays(int[] bloomDay, int m, int k) {
		int n = bloomDay.length;
		if (m * k > n)
			return -1;
		int lo = 1;
		int hi = 0;
		for (int day : bloomDay)
			hi = Math.max(hi, day);

		while (lo < hi) {
			int mi = lo + hi >> 1;
			boolean ok = check(mi, bloomDay, m, k);
			if (ok)
				hi = mi;
			else
				lo = mi + 1;
		}
		return hi;
	}

	boolean check(int mi, int[] days, int m, int k) {
		int conseq = 0;
		int bouquets = 0;
		for (int day : days) {
			if (day <= mi) {
				conseq++;
				if (conseq == k) {
					bouquets++;
					conseq = 0;
				}
			} else {
				conseq = 0;
			}
		}
		return bouquets >= m;
	}
}
