package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001423_MaximumPointsYouCanObtainFromCards {
	public int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length;
		int[] cum = new int[n];
		cum[0] = cardPoints[0];
		for (int i = 1; i < n; i++)
			cum[i] = cum[i - 1] + cardPoints[i];
		if (k == n)
			return sum(0, n - 1, cum);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= k; i++) {
			min = Math.min(min, sum(i, n - k + i - 1, cum));
		}
		return sum(0, n - 1, cum) - min;

	}

	int sum(int from, int to, int[] cum) {
		return cum[to] - (from == 0 ? 0 : cum[from - 1]);
	}
}
