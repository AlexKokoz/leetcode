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
public class _000310_MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[] deg = new int[n];
		@SuppressWarnings("unchecked")
		List<Integer>[] adj = new List[n];

		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
		for (int[] e : edges) {
			adj[e[0]].add(e[1]);
			adj[e[1]].add(e[0]);
			deg[e[0]]++;
			deg[e[1]]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			if (deg[i] <= 1)
				q.add(i);
		int rem = n;
		while (rem > 2) {
			for (int i = 0, len = q.size(); i < len; i++) {
				int v = q.poll();
				for (int w : adj[v]) {
					deg[w]--;
					if (deg[w] == 1)
						q.add(w);
				}
				rem--;
			}
		}
		List<Integer> ans = new LinkedList<>();
		while (!q.isEmpty())
			ans.add(q.poll());
		return ans;
	}
}
