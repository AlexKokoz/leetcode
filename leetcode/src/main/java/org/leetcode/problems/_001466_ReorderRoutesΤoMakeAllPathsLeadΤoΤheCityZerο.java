package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001466_ReorderRoutesΤoMakeAllPathsLeadΤoΤheCityZerο {
	int ans;

	public int minReorder(int n, int[][] connections) {
		Set<Integer>[] oneway = new Set[n];
		for (int i = 0; i < n; i++)
			oneway[i] = new HashSet<>();
		Set<Integer>[] twoway = new Set[n];
		for (int i = 0; i < n; i++)
			twoway[i] = new HashSet<>();
		for (int[] edge : connections) {
			oneway[edge[0]].add(edge[1]);
			twoway[edge[0]].add(edge[1]);
			twoway[edge[1]].add(edge[0]);
		}
		dfs(-1, 0, oneway, twoway);
		return ans;
	}
	
	void dfs(int par, int ch, Set<Integer>[] oneway, Set<Integer>[] twoway) {
		for (int nch : twoway[ch]) {
			if (par == nch) continue;
			if (oneway[ch].contains(nch)) ans++;
			dfs(ch, nch, oneway, twoway);
		}
	}
}
