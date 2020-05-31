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
public class _000886_PossibleBipartition {
	@SuppressWarnings("unchecked")
	public boolean possibleBipartition(int N, int[][] dislikes) {
		Boolean[] groups = new Boolean[N];
		Queue<Integer>[] adj = new Queue[N];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int[] dislike : dislikes) {
			int v = dislike[0] - 1;
			int w = dislike[1] - 1;
			adj[v].add(w);
			adj[w].add(v);
		}

		for (int i = 0; i < N; i++) {
			if (groups[i] != null)
				continue;
			groups[i] = true;
			if (!dfs(i, adj, groups)) {
				return false;
			}
		}
		return true;
	}

	static boolean dfs(int ch, Queue<Integer>[] adj, Boolean[] groups) {
		for (int nch : adj[ch]) {
			if (groups[nch] != null) {
				if (groups[ch] == groups[nch])
					return false;
				else
					continue;
			}
			groups[nch] = !groups[ch];
			dfs(nch, adj, groups);
		}
		return true;
	}
}
