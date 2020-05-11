package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001443_MinimumTimeToCollectAllApplesInATree {
	int ans;

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		@SuppressWarnings("unchecked")
		Queue<Integer>[] adj = new Queue[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}
		ans = 0;
		dfs(-1, 0, adj, hasApple);
		return ans;
	}

	boolean dfs(int p, int ch, Queue<Integer>[] adj, List<Boolean> hasApple) {
		boolean appleFound = hasApple.get(ch);
		for (int nch : adj[ch]) {
			if (nch == p) {
				continue;
			}
			appleFound = dfs(ch, nch, adj, hasApple) || appleFound;
		}
		if (appleFound && p != -1) {
			ans += 2;
		}
		return appleFound;
	}
}
