package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001563_StoneGameV {
	static Integer[][] memo;
	static int[] cum;

	public int stoneGameV(int[] stoneValue) {
		int n = stoneValue.length;
		memo = new Integer[n][n];
		cum = Arrays.copyOf(stoneValue, stoneValue.length);
		Arrays.parallelPrefix(cum, (a, b) -> a + b);

		return dp(0, n - 1);

	}

	static int dp(int lo, int hi) {
		if (memo[lo][hi] != null)
			return memo[lo][hi];
		if (lo == hi) {
			memo[lo][hi] = 0;

		} else {
			int v = 0;
			for (int mi = lo; mi < hi; mi++) {
				int lSum = sum(lo, mi, cum);
				int rSum = sum(mi + 1, hi, cum);
				if (lSum >= rSum) {
					v = Math.max(v,  rSum + dp(mi + 1, hi));
				}
				if(lSum <= rSum) {
					v = Math.max(v, lSum + dp(lo , mi));
				}
			}
			memo[lo][hi] = v;
		}
		return memo[lo][hi];
	}

	static int sum(int from, int to, int[] cum) {
		return cum[to] - (from == 0 ? 0 : cum[from - 1]);
	}

	static long sum(int from, int to, long[] cum) {
		return cum[to] - (from == 0 ? 0 : cum[from - 1]);
	}
}
