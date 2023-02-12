package org.leetcode.contests.weekly.w0308;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	
	// Idea is to topologically sort the values based on the row conditions and then on the col conditions
	public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
		List<Integer> topBottom = topSort(rowConditions, k);
		if (topBottom == null)
			return new int[0][];
		List<Integer> leftRight = topSort(colConditions, k);
		if (leftRight == null)
			return new int[0][];
		int[][] ret = new int[k][k];
		Map<Integer, Integer> colpos = new HashMap<>();
		for (int i = 0; i < k; i++) {
			colpos.put(leftRight.get(i), i);
		}
		for (int r = 0; r < k; r++) {
			ret[r][colpos.get(topBottom.get(r))] = topBottom.get(r) + 1;
		}
		return ret;
	}

	List<Integer> topSort(int[][] conds, int k) {
		int n = conds.length;
		int[] from = new int[n];
		int[] to = new int[n];
		for (int i = 0; i < n; i++) {
			from[i] = conds[i][0] - 1;
			to[i] = conds[i][1] - 1;
		}
		int[][] adj = packD(k, from, to);
		return recursiveTopologicalSort(adj);
	}

	static List<Integer> recursiveTopologicalSort(int[][] adj) {
		int n = adj.length;
		List<Integer> sorted = new ArrayList<>();
		int[] status = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++)
			if (!dfs(-1, i, adj, status, stack))
				return null;
		while (!stack.isEmpty())
			sorted.add(stack.pop());
		return sorted;
	}

	static boolean dfs(int p, int ch, int[][] adj, int[] status, Stack<Integer> stack) {
		final int PROCESSING = 1, PROCESSED = 2; // UNPROCESSED = 0
		if (status[ch] == PROCESSED)
			return true;
		if (status[ch] == PROCESSING)
			return false;
		status[ch] = PROCESSING;
		for (int nch : adj[ch]) {
			if (!dfs(ch, nch, adj, status, stack))
				return false;
		}
		status[ch] = PROCESSED;
		stack.add(ch);
		return true;
	}

	int[][] packD(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++)
			out[from[i]]++;
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++)
			ret[from[i]][--out[from[i]]] = to[i];
		return ret;
	}

}
