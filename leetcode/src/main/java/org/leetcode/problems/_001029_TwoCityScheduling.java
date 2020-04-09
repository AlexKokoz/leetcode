package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class _001029_TwoCityScheduling {

	public int twoCitySchedCost(int[][] costs) {
		final int n = costs.length;
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				int d1 = Math.abs(a[0] - a[1]);
				int d2 = Math.abs(b[0] - b[1]);
				if (d1 > d2)
					return -1;
				if (d1 < d2)
					return 1;
				return 0;
			}
		});

		int A = 0, B = 0;
		final int lim = n / 2;
		int ans = 0;
		for (int[] cost : costs) {
			if (cost[0] < cost[1]) {
				if (A < lim) {
					ans += cost[0];
					A++;
				} else {
					ans += cost[1];
					B++;
				}
			} else {
				if (B < lim) {
					ans += cost[1];
					B++;
				} else {
					ans += cost[0];
					A++;
				}
			}
		}
		return ans;
	}

}
