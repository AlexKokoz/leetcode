package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000210_CourseScheduleII {


	public int[] findOrder(int n, int[][] prerequisites) {
		int p = prerequisites.length;
		int[] from = new int[p];
		int[] to = new int[p];
		for (int i = 0; i < p ; i++) {
			from[i] = prerequisites[i][1];
			to[i] = prerequisites[i][0];
		}
		int[][] adj = packD(n, from, to);
		Iterable<Integer> sorted = iterativeTopologicalSort(adj);
		if (sorted == null)
			return new int[0];
		int index = 0;
		int[] order = new int[n];
		for (int course : sorted)
			order[index++] = course;
		return order;
	}

	
	static Iterable<Integer> iterativeTopologicalSort(int[][] adj) {
		int n = adj.length;
		int[] indeg = new int[n];
		for (int from = 0; from < n; from++) {
			for (int to : adj[from]) {
				indeg[to]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int v = 0; v < n; v++) {
			if (indeg[v] == 0) {
				q.add(v);
			}
		}
		Queue<Integer> sorted = new LinkedList<>();
		while (!q.isEmpty()) {
			int cur = q.poll();
			sorted.add(cur);
			for (int to : adj[cur]) {
				indeg[to]--;
				if (indeg[to] == 0)
					q.add(to);
			}
		}
		return sorted.size() == n ? sorted : null;
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
