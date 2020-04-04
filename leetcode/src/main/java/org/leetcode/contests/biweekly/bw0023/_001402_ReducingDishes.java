package org.leetcode.contests.biweekly.bw0023;

import java.util.*;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001402_ReducingDishes {
	public int maxSatisfaction(int[] satisfaction) {
		int n = satisfaction.length;
		Arrays.sort(satisfaction);
		if (satisfaction[n - 1] < 0)
			return 0;
		int[] cum = new int[n];
		cum[0] = satisfaction[0];
		for (int i = 1; i < n; i++)
			cum[i] = cum[i - 1] + satisfaction[i];
		int start;
		for (start = n - 2; start >= 0; start--) {
			if (Math.abs(satisfaction[start]) > sum(start + 1, n - 1, cum))
				break;
		}
		start++;
		int ans = 0;
		for (int i = 1; start < n; i++, start++)
			ans += i * satisfaction[start];
		return ans;
	}

	int sum(int from, int to, int[] cum) {
		return cum[to] - (from == 0 ? 0 : cum[from - 1]);
	}
}
