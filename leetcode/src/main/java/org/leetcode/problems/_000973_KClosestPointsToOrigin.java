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
public class _000973_KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				int distA = a[1] * a[1] + a[0] * a[0];
				int distB = b[1] * b[1] + b[0] * b[0];
				return distA - distB;
			}
		});
		return Arrays.copyOf(points, K);
	}
}
