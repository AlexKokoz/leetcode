package org.leetcode.contests.biweekly.bw0086;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int maximumRobots(int[] cts, int[] rcs, long budget) {
		int n = cts.length;
		long[] cum = new long[n + 1];
		for (int i = 0; i < n; i++) {
			cum[i + 1] = cum[i] + rcs[i];
		}
		int ans = 0;

		int lo = 1;
		int hi = n;
		while (lo <= hi) {
			int mi = lo + (hi - lo) / 2;
			if (ok(cts, rcs, budget, cum, mi)) {
				ans = mi;
				lo = mi + 1;
			} else {
				hi = mi - 1;
			}
		}

		return ans;
	}

	boolean ok(int[] cts, int[] rcs, long budget, long[] cum, int cand) {
		int n = cts.length;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < cand; i++) {
			while (!dq.isEmpty() && cts[i] > dq.peekLast()) {
				dq.pollLast();
			}
			dq.addLast(cts[i]);
		}
		if (dq.peekFirst() + cand * cum[cand] <= budget)
			return true;
		for (int i = cand; i < n; i++) {
			while (!dq.isEmpty() && cts[i] > dq.peekLast()) {
				dq.pollLast();
			}
			if (!dq.isEmpty() && dq.peekFirst() == cts[i - cand])
				dq.pollFirst();
			dq.addLast(cts[i]);
			if (dq.peekFirst() + cand * (cum[i + 1] - cum[i + 1 - cand]) <= budget)
				return true;
		}

		return false;

	}
}
