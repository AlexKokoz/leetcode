package org.leetcode.contests.weekly.w0305;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	int ans;

	public int reachableNodes(int n, int[][] edges, int[] restricted) {
		int[] from = new int[n - 1];
		int[] to = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			from[i] = edges[i][0];
			to[i] = edges[i][1];
		}
		int[][] adj = packU(n, from, to);
		Set<Integer> bads = new HashSet<>();
		for (int x : restricted)
			bads.add(x);
		dfs(-1, 0, adj, bads);
		return ans;
	}

	void dfs(int p, int ch, int[][] adj, Set<Integer> bads) {
		ans++;
		for (int nch : adj[ch]) {
			if (nch == p || bads.contains(nch))
				continue;
			dfs(ch, nch, adj, bads);
		}
	}

	int[][] packU(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++) {
			out[to[i]]++;
			out[from[i]]++;
		}
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++) {
			ret[from[i]][--out[from[i]]] = to[i];
			ret[to[i]][--out[to[i]]] = from[i];
		}
		return ret;
	}
}
