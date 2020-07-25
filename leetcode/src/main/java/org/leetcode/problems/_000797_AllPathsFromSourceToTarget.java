package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000797_AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] adj) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(0, adj.length - 1, adj, new boolean[adj.length], new ArrayList<>(), ans);
		return ans;
	}

	void dfs(int cur, int target, int[][] adj, boolean[] seen, List<Integer> path, List<List<Integer>> paths) {

		if (cur == target) {
			path.add(cur);
			paths.add(new ArrayList<>(path));
			path.remove(path.size() - 1);
			return;
		}
		path.add(cur);
		seen[cur] = true;
		for (int next : adj[cur]) {
			if (seen[next])
				continue;
			dfs(next, target, adj, seen, path, paths);
		}
		path.remove(path.size() - 1);
		seen[cur] = false;
	}
}
