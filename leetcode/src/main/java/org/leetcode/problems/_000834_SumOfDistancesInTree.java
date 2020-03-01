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
public class _000834_SumOfDistancesInTree {

	List<Integer>[] adj;
	int[] size;
	int[] sub;
	int N;

	@SuppressWarnings("unchecked")
	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		this.N = N;
		adj = new List[N];
		for (int i = 0; i < N; i++)
			adj[i] = new LinkedList<>();
		for (int[] e : edges) {
			adj[e[0]].add(e[1]);
			adj[e[1]].add(e[0]);
		}
		size = new int[N];
		sub = new int[N];
		dfs(-1, 0);
		dfs2(-1, 0);
		return sub;
	}

	// {size, subcount}
	int[] dfs(int p, int ch) {
		for (int nch : adj[ch]) {
			if (nch == p)
				continue;
			int[] dfs = dfs(ch, nch);
			size[ch] += dfs[0];
			sub[ch] += dfs[1] + dfs[0];
		}
		return new int[] { size[ch] + 1, sub[ch] };
	}

	void dfs2(int p, int ch) {
		if (ch != 0) {
			int psub = sub[p] - sub[ch] - size[ch] - 1;
			int psize = N - 1 - size[ch]; // size[p] - size[ch];
			sub[ch] = psub + psize;
		}
		for (int nch : adj[ch]) {
			if (nch == p)
				continue;
			dfs2(ch, nch);
		}
	}

}
