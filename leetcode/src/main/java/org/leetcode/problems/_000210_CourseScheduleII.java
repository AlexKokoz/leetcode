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

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		@SuppressWarnings("unchecked")
		List<Integer>[] adj = new List[numCourses];
		for (int i = 0; i < numCourses; i++)
			adj[i] = new LinkedList<>();
		for (int[] prerequisite : prerequisites)
			adj[prerequisite[1]].add(prerequisite[0]);
		int[] order = new int[numCourses];
		int index = 0;
		Iterable<Integer> sorted = topologicalSort(adj, numCourses);
		if (sorted == null)
			return new int[0];
		for (int course : sorted)
			order[index++] = course;
		return order;
	}

	Iterable<Integer> topologicalSort(List<Integer>[] adj, int n) {
		List<Integer> sorted = new LinkedList<>();
		int[] status = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++)
			if (!dfs(-1, i, adj, status, stack))
				return null;
		while (!stack.isEmpty())
			sorted.add(stack.pop());
		return sorted;
	}

	boolean dfs(int p, int ch, List<Integer>[] adj, int[] status, Stack<Integer> stack) {
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
}
