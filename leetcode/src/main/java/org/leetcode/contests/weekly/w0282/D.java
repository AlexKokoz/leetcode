package org.leetcode.contests.weekly.w0282;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
		int n = tires.length;
		int LAP_LIMIT = 18;
		long[] best = new long[LAP_LIMIT + 1];
		Arrays.fill(best, Integer.MAX_VALUE);
		for (int i = 0; i < n; i++) {
			long f = tires[i][0];
			long r = tires[i][1];
			long successiveCost = 0;
			for (int lap = 1; lap <= LAP_LIMIT; lap++) {
				long lapCost = f * (long) Math.pow(r, lap - 1);
				successiveCost += lapCost;
				if (successiveCost < best[lap]) {
					best[lap] = successiveCost;
					continue;
				}
				if (successiveCost >= Integer.MAX_VALUE)
					break;
			}
		}
		long[] dp = new long[numLaps + 1];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;
		for (int cur = 1; cur <= numLaps; cur++) {
			for (int prev = Math.max(0, cur - LAP_LIMIT); prev < cur; prev++) {
				int dist = cur - prev;
				dp[cur] = Math.min(dp[cur], dp[prev] + best[dist] + (prev != 0 ? changeTime : 0));
			}
		}
		return (int) dp[numLaps];
	}
}
