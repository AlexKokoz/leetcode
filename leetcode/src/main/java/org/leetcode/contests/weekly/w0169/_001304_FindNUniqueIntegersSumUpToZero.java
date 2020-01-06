package org.leetcode.contests.weekly.w0169;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001304_FindNUniqueIntegersSumUpToZero {
	public int[] sumZero(int n) {
		final int[] ans = new int[n];
		int mi = -n / 2;
		for (int i = 0; i < n; i++) {
			ans[i] = mi;
			mi++;
			if (mi == 0 && n % 2 == 0)
				mi++;
		}
		return ans;
	}
}
