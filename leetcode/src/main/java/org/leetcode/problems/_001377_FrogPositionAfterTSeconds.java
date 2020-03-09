package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001377_FrogPositionAfterTSeconds {
	List<Integer>[] adj;
	int t;
	int target;
	Double ans;

	@SuppressWarnings("unchecked")
	public double frogPosition(int n, int[][] edges, int t, int target) {
		this.t = t;
		this.target = target;
		adj = new List[n + 1];
		for (int i = 0; i < adj.length; i++)
			adj[i] = new LinkedList<>();
		for (int[] e : edges) {
			adj[e[0]].add(e[1]);
			adj[e[1]].add(e[0]);
		}
		dfs(0, 1, 0, 1);
		return ans == null ? 0 : ans;
	}

	void dfs(int par, int node, int s, double p) {
		System.out.println("node = " + node + " p = " + p);
		if (ans != null)
			return;
		if (s == t || (adj[node].size() - (node == 1 ? 0 : 1) == 0)) {
			if (node == target)
				ans = p;
			return;
		}

		for (int to : adj[node]) {
			if (to == par)
				continue;
			dfs(node, to, s + 1, p * (1.0 / (adj[node].size() - (node == 1 ? 0 : 1))));
		}

	}
}
