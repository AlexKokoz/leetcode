package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001439_FindTheKthSmallestSumOfAMatrixWithSortedRows {
	public int kthSmallest(int[][] mat, int k) {
		int[] cum = new int[] { 0 };
		for (int[] row : mat) {
			int[] ncum = new int[row.length * cum.length];
			int index = 0;
			for (int nval : row) {
				for (int val : cum) {
					ncum[index++] = nval + val;
				}
			}
			Arrays.sort(ncum);
			if (ncum.length > k)
				ncum = Arrays.copyOf(ncum, k);
			cum = ncum;
		}
		return cum[k - 1];
	}
}
