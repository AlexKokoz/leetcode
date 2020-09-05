package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000452_MinimumNumberOfArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		int n = points.length;
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		int ans = n;
		for (int i = 1, j = 0; i < n; i++) {
			int[] cur = points[i];
			int[] pre = points[j];
			if (intersect(cur, pre)) {
				points[i][0] = Math.max(cur[0], pre[0]);
				points[i][1] = Math.min(cur[1], pre[1]);
				ans--;
			}
			j = i;
		}

		return ans;
	}

	static boolean intersect(int[] a, int[] b) {
		return a[0] <= b[1] && b[0] <= a[1];
	}
}
