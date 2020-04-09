package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001184_DistanceBetweenBusStops {
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		if (start == destination)
			return 0;
		int n = distance.length;
		int[] cum = new int[n];
		cum[0] = distance[0];
		for (int i = 1; i < n; i++)
			cum[i] = cum[i - 1] + distance[i];
		int min = Math.min(start, destination);
		int max = Math.max(start, destination);
		return Math.min(getCumSum(min, max - 1, cum), cum[n - 1] - getCumSum(min, max - 1, cum));
	}

	int getCumSum(int from, int to, int[] cum) {
		return cum[to] - (from == 0 ? 0 : cum[from - 1]);
	}
}
