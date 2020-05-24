package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000896_IntervalListIntersections {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> list = new LinkedList<>();
		int na = A.length;
		int nb = B.length;
		int ia = 0;
		int ib = 0;
		while (ia < na && ib < nb) {
			if (A[ia][1] < B[ib][0]) {
				ia++;
			} else if (A[ia][0] > B[ib][1]) {
				ib++;
			} else {
				int[] intersection = intersection(A[ia], B[ib]);
				list.add(intersection);
				if (A[ia][1] < B[ib][1]) {
					ia++;
				} else if (A[ia][1] > B[ib][1]) {
					ib++;
				} else {
					ia++;
					ib++;
				}
			}
		}
		int[][] ans = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

	int[] intersection(int[] interval1, int[] interval2) {
		return new int[] { Math.max(interval1[0], interval2[0]), Math.min(interval1[1], interval2[1]) };
	}
}
