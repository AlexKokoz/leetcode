package org.leetcode.contests.biweekly.bw0070;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int numberOfWays(String corridor) {
		char[] cs = corridor.toCharArray();
		int n = cs.length;
		long mod = (long) 1e9 + 7;
		long[] dp = new long[n];
		int secondToLastSeat = -1, lastSeat = -1, seatCount = 0;
		long ans = 0;
		for (int i = 0; i < n; i++) {
			if (cs[i] == 'P')
				continue;
			seatCount++;
			if (seatCount == 2) {
				dp[i] = 1;
			} else if (seatCount % 2 == 0) {
				dp[i] = dp[secondToLastSeat] * (lastSeat - secondToLastSeat);
				dp[i] %= mod;
			}
			ans = dp[i];
			secondToLastSeat = lastSeat;
			lastSeat = i;
		}
		return (int) ans;
	}
}
