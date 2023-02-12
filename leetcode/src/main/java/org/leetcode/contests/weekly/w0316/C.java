package org.leetcode.contests.weekly.w0316;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long minCost(int[] nums, int[] cost) {
		int n = nums.length;
		long ans = Long.MAX_VALUE;
		int[][] nc = new int[n][];
		for (int i = 0; i < n; i++) {
			nc[i] = new int[] { nums[i], cost[i] };
		}
		Arrays.sort(nc, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});
		long[] lr = new long[n];
		long pref = nc[0][1];
		for (int i = 1; i < n; i++) {
			lr[i] = lr[i - 1] + (nc[i][0] - nc[i - 1][0]) * pref;
			pref += nc[i][1];
		}
		long[] rl = new long[n];
		long suff = nc[n - 1][1];
		for (int i = n - 2; i >= 0; i--) {
			rl[i] = rl[i + 1] + (nc[i + 1][0] - nc[i][0]) * suff;
			suff += nc[i][1];
		}
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, lr[i] + rl[i]);
		}

		return ans;
	}
}
