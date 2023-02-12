package org.leetcode.contests.biweekly.bw0045;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _1751_MaximumNumberOfEventsThatCanBeAttendedII {
	public int maxValue(int[][] events, int k) {
		int ans = 0;
		int n = events.length;
		int[][] dp = new int[k + 1][n + 1];
		Arrays.sort(events, (a, b) -> {
			return Integer.compare(a[1], b[1]);
		});
		for (int i = 0; i < n; i++) {
			for (int b = 0; b < dp.length; b++)
				dp[b][i + 1] = dp[b][i];

			int last = lowerBound(events[i][0], events, 0, i - 1);
			for (int b = 1; b <= k; b++) {
				dp[b][i + 1] = Math.max(dp[b][i + 1], dp[b - 1][last + 1] + events[i][2]);
				ans = Math.max(ans, dp[b][i + 1]);
			}
		}

		return ans;
	}

	// returns position of the highest lower value of key between [l, r]; r otherwise
	static int lowerBound(int key, int[][] es, int l, int r) {
		assert l <= r;
		int ans = -1;
		int lo = l, hi = r;
		while (lo <= hi) {
			int mi = lo + (hi - lo >>> 1);
			if (key > es[mi][1]) {
				ans = mi;
				lo = mi + 1;
			} else {
				hi = mi - 1;
			}
		}
		return ans;
	}
}
