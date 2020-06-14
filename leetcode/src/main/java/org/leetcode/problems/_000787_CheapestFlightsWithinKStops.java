package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000787_CheapestFlightsWithinKStops {
	int ans;

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		ans = Integer.MAX_VALUE;
		@SuppressWarnings("unchecked")
		Queue<Pair>[] adj = new Queue[n];
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
		for (int[] flight : flights) {
			int from = flight[0];
			int to = flight[1];
			int cost = flight[2];
			adj[from].add(new Pair(to, cost));
		}
		boolean[] visited = new boolean[n];
		dfs(-1, src, dst, k, adj, visited, 0);
		return (ans == Integer.MAX_VALUE) ? -1 : ans;
	}

	static class Pair {
		int to, cost;

		public Pair(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		public String toString() {
			return "(" + to + ", " + cost + ")";
		}
	}

	void dfs(int par, int cur, int dst, int k, Iterable<Pair>[] adj, boolean[] visited, int runningCost) {
		if (cur == dst) {
			ans = Math.min(ans, runningCost);
			return;
		}
		if (k < 0 || runningCost >= ans)
			return;
		visited[cur] = true;
		for (Pair nei : adj[cur]) {
			int to = nei.to;
			int cost = nei.cost;
			if (visited[to] || to == par)
				continue;
			dfs(cur, to, dst, k - 1, adj, visited, runningCost + cost);
		}
		visited[cur] = false;
	}
}
