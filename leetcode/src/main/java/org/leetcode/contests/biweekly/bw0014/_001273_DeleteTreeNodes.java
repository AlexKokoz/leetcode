package org.leetcode.contests.biweekly.bw0014;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MEDIUM
 * 
 * @author AccelSprinter
 *
 */
public class _001273_DeleteTreeNodes {

	public int deleteTreeNodes(int nodes, int[] parent, int[] value) {

		@SuppressWarnings("unchecked")
		final Queue<Integer>[] adj = new Queue[nodes];
		for (int i = 0; i < nodes; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 1; i < nodes; i++) {
			final int p = parent[i];
			adj[p].add(i);
		}
		int[] cum = new int[nodes];
		for (int i = 0; i < nodes; i++)
			cum[i] = value[i];
		dfs(0, 0, cum, parent, value, adj);
		int ans = dfs2(0, 0, cum, adj);
		return ans;
	}

	static void dfs(int cur, int par, int[] cum, int[] parent, int[] value, Queue<Integer>[] adj) {
		for (int w : adj[cur]) {
			if (w == par)
				continue;
			dfs(w, cur, cum, parent, value, adj);
			cum[cur] += cum[w];
		}
	}

	static int dfs2(int cur, int par, int[] cum, Queue<Integer>[] adj) {
		if (cum[cur] == 0)
			return 0;
		int ans = 1;
		for (int w : adj[cur]) {
			if (w == par)
				continue;
			ans += dfs2(w, cur, cum, adj);
		}
		return ans;
	}

}
