package org.leetcode.contests.weekly.w0180;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001383_MaximumPerformanceOfATeam {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		long mod = (long) 1e9 + 7;
		int[][] both = new int[n][2];
		long ans = 0;
		long sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			both[i][0] = speed[i];
			both[i][1] = efficiency[i];
		}
		Arrays.sort(both, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] < b[1] ? 1 : a[1] > b[1] ? -1 : 0; // descending
			}
		});
		for (int i = 0; i < n; i++) {
			pq.add(both[i][0]);
			sum += both[i][0];
			if (pq.size() > k)
				sum -= pq.poll();
			ans = Math.max(ans, sum * both[i][1]);
		}
		return (int) (ans % mod);
	}
}
