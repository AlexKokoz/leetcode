package org.leetcode.contests.biweekly.bw0036;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001605_FindValidMatrixGivenRowAndColumnSums {
	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int n = rowSum.length;
		int m = colSum.length;
		int[][] ans = new int[n][m];

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		for (int r = 0; r < n; r++)
			pq.add(new int[] { r, rowSum[r] });

		for (int c = 0; c < m; c++) {
			int rem = colSum[c];
			while (rem > 0) {
				int[] cur = pq.poll();
				int r = cur[0];
				int capacity = cur[1];
				if (rem >= capacity) {
					rem -= capacity;
					ans[r][c] = capacity;
				} else {
					ans[r][c] = rem;
					cur[1] = capacity - rem;
					pq.add(cur);
					rem = 0;
				}
			}
		}
		return ans;
	}
}
