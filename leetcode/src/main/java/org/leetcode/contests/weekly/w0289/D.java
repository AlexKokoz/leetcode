package org.leetcode.contests.weekly.w0289;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	int ans;

	public int longestPath(int[] parent, String s) {
		int n = parent.length;
		int[] from = new int[n - 1];
		int[] to = new int[n - 1];
		for (int i = 1; i < n; i++) {
			from[i - 1] = i;
			to[i - 1] = parent[i];
		}
		int[][] adj = packU(n, from, to);
		dfs(0, adj, parent, s);

		return ans;
	}

	int dfs(int cur, int[][] adj, int[] parent, String s) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		for (int nei : adj[cur]) {
			if (nei == parent[cur])
				continue;
			int len = dfs(nei, adj, parent, s);
			if (s.charAt(cur) != s.charAt(nei)) {
				list.add(len);
			}
		}
		Collections.sort(list);
		ans = Math.max(ans, 1 + list.get(list.size() - 1) + list.get(list.size() - 2));
		return 1 + list.get(list.size() - 1);
	}

	static int[][] packU(int n, int[] from, int[] to) {
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
