package org.leetcode.contests.weekly.w0223;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001723_FindMinimumTimeToFinishAllJobs {

	public int minimumTimeRequired(int[] jobs, int w) {
		int j = jobs.length;
		int[] dp = new int[1 << j];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] amount = new int[1 << j];
		for (int i = 1; i < 1 << j; i++) {
			amount[i] = amount[i & i - 1] + jobs[Integer.numberOfTrailingZeros(i)];
		}
		for (int workers = w; workers > 0; workers--) {
			for (int mask = (1 << j) - 1; mask >= 0; mask--) {
				for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
					dp[mask] = Math.min(dp[mask], Math.max(dp[mask ^ sub], amount[sub]));
				}
			}
		}
		return dp[(1 << j) - 1];
	}
}
