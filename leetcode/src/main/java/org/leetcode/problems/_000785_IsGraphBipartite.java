package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000785_IsGraphBipartite {
	boolean flag;
	Set<Integer> seta, setb;
	int[][] g;

	public boolean isBipartite(int[][] g) {
		int n = g.length;
		this.g = g;
		seta = new HashSet<>();
		setb = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (seta.contains(i) ^ setb.contains(i))
				continue;
			dfs(i, true);
		}
		return flag ? false : true;
	}

	void dfs(int node, boolean toA) {
		if (flag)
			return;
		if (seta.contains(node)) {
			if (!toA)
				flag = true;
			return;
		} else if (setb.contains(node)) {
			if (toA)
				flag = true;
			return;
		}
		if (toA)
			seta.add(node);
		else
			setb.add(node);
		for (int adj : g[node]) {
			dfs(adj, !toA);
		}
	}
}
