package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001334_FindCityWithSmallestNumberofNeighborsThresholdDistance {

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int[][] dist = new int[n][n];

		// Initialize distances
		for (int[] row : dist)
			Arrays.fill(row, (int) 1e9);
		for (int i = 0; i < n; i++)
			dist[i][i] = 0;
		for (int[] e : edges) {
			int from = e[0];
			int to = e[1];
			int w = e[2];
			dist[from][to] = dist[to][from] = Math.min(dist[from][to], w);
		}

		// Brute Force Dijkstra :)
		for (int mid = 0; mid < n; mid++) {
			for (int from = 0; from < n; from++) {
				for (int to = 0; to < n; to++) {
					dist[from][to] = Math.min(dist[from][to], dist[from][mid] + dist[mid][to]);
				}
			}
		}

		// Count closest neighbors within threshold
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int from = 0; from < n; from++) {
			int count = 0;
			for (int to = 0; to < n; to++) {
				if (from == to)
					continue;
				if (dist[from][to] <= distanceThreshold)
					count++;
			}
			if (count <= min) {
				min = count;
				index = from;
			}
		}

		return index;
	}

}
