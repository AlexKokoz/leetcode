package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001203_SortItemsByGroupsRespectingDependencies {
	@SuppressWarnings("unchecked")
	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

		Queue<Integer>[] inGroup = new Queue[m];
		for (int i = 0; i < inGroup.length; i++)
			inGroup[i] = new LinkedList<>();
		for (int i = 0; i < group.length; i++) {
			int g = group[i];
			if (g == -1)
				continue;
			inGroup[g].add(i);
		}

		Queue<Integer>[] adj = new Queue[n + m + m];
		for (int i = 0; i < adj.length; i++)
			adj[i] = new LinkedList<>();

		for (int g = 0; g < m; g++) {
			for (int groupItem : inGroup[g]) {
				adj[n + g].add(groupItem);
				adj[groupItem].add(n + m + g);
			}
		}

		for (int to = 0; to < beforeItems.size(); to++) {
			List<Integer> curBefore = beforeItems.get(to);
			if (curBefore.isEmpty())
				continue;
			int toGroup = group[to];
			if (toGroup == -1) {
				for (int from : curBefore) {
					int fromGroup = group[from];
					if (fromGroup == -1) {
						adj[from].add(to);
					} else {
						adj[n + m + fromGroup].add(to);
					}

				}
			} else {
				for (int from : curBefore) {
					int fromGroup = group[from];
					if (fromGroup == -1) {
						adj[from].add(n + toGroup);
					} else if (fromGroup == toGroup) {
						adj[from].add(to);
					} else {
						adj[n + m + fromGroup].add(n + toGroup);
					}

				}
			}
		}

		Iterable<Integer> sorted = recursiveTopologicalSort(adj, n);

		if (sorted == null) {
			return new int[0];
		}

		int[] ans = new int[n];
		int index = 0;
		for (int v : sorted) {
			if (v >= n)
				continue;
			ans[index++] = v;
		}
		return ans;
	}

	static Iterable<Integer> recursiveTopologicalSort(Iterable<Integer>[] adj, int startOfDependencyNodes) {
		int n = adj.length;
		Queue<Integer> sorted = new LinkedList<>();
		int[] status = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = startOfDependencyNodes; i < n; i++)
			if (!dfs(-1, i, adj, status, stack))
				return null;
		for (int i = 0; i < startOfDependencyNodes; i++)
			if (!dfs(-1, i, adj, status, stack))
				return null;
		while (!stack.isEmpty())
			sorted.add(stack.pop());
		return sorted;
	}

	static boolean dfs(int p, int ch, Iterable<Integer>[] adj, int[] status, Stack<Integer> stack) {
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
