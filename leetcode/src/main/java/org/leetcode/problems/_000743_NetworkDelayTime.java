package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000743_NetworkDelayTime {
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
		for (int[] e : times)
			adj.computeIfAbsent(e[0] - 1, k -> new HashMap<>()).put(e[1] - 1, e[2]);
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K - 1] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(K - 1);
		while (!q.isEmpty()) {
			int cur = q.poll();
			Map<Integer, Integer> weights = adj.get(cur);
			if (weights == null)
				continue;
			for (int v : weights.keySet()) {
				int w = weights.get(v);
				if (dist[v] > dist[cur] + w) {
					dist[v] = dist[cur] + w;
					q.add(v);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int x : dist)
			max = Math.max(max, x);

		return max == Integer.MAX_VALUE ? -1 : max;
	}
}
