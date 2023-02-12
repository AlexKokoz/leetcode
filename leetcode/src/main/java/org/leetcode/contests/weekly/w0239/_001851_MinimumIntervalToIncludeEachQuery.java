package org.leetcode.contests.weekly.w0239;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001851_MinimumIntervalToIncludeEachQuery {

	public int[] minInterval(int[][] is, int[] qs) {
		int nq = qs.length, ni = is.length;
		int[] ans = new int[nq];
		Arrays.sort(is, (a, b) -> {
			return a[0] - b[0];
		});
		int[][] ai = new int[nq][];
		for (int i = 0; i < nq; i++) {
			ai[i] = new int[] { qs[i], i };
		}
		Arrays.sort(ai, (a, b) -> {
			return a[0] - b[0];
		});
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0] + 1) - (b[1] - b[0] + 1));
		int p = 0;
		for (int[] q : ai) {
			while (p < ni && is[p][0] <= q[0]) {
				pq.add(is[p++]);
			}
			while (!pq.isEmpty() && pq.peek()[1] < q[0])
				pq.poll();
			if (pq.isEmpty())
				ans[q[1]] = -1;
			else {
				ans[q[1]] = pq.peek()[1] - pq.peek()[0] + 1;
			}
		}
		return ans;
	}

}
