package org.leetcode.contests.weekly.w0210;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001615_MaximalNetworkRank {
	public int maximalNetworkRank(int n, int[][] roads) {
		@SuppressWarnings("unchecked")
		Set<Integer>[] adj = new Set[n];
		for (int i = 0; i < n; i++)
			adj[i] = new HashSet<>();
		for (int[] road : roads) {
			int v = road[0];
			int u = road[1];
			adj[v].add(u);
			adj[u].add(v);
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				int cand = adj[i].size() + adj[j].size();
				if (adj[i].contains(j))
					cand--;
				max = Math.max(max, cand);
			}
		}

		return max;

	}
}
