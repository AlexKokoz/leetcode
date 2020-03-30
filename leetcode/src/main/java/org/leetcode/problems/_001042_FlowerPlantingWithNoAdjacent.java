package org.leetcode.problems;

import java.util.*;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001042_FlowerPlantingWithNoAdjacent {
	public int[] gardenNoAdj(int n, int[][] paths) {
		int[] flowers = new int[n];
		@SuppressWarnings("unchecked")
		List<Integer>[] adj = new List[n];
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
		for (int[] e : paths) {
			adj[e[0]].add(e[1]);
			adj[e[1]].add(e[0]);
		}
		for(int i = 0; i < n; i++) {
			if (flowers[i] > 0) continue;
			dfs(-1, i, flowers, adj);
		}
		return flowers;
	}
	
	void dfs(int p, int ch, int[] f, List<Integer>[] adj) {
		boolean[] assigned = new boolean[5];
		for (int nch : adj[ch]) {
			assigned[f[nch]] = true;
		}
		for (int i = 1; i <= assigned.length; i++)
			if (!assigned[i]) {
				f[ch] = i;
				assigned[i] = true;
				break;
			}
		for (int nch : adj[ch]) {
			if (nch == p || f[nch] > 0) continue;
			dfs(ch,nch, f, adj);
		}
	}
}
