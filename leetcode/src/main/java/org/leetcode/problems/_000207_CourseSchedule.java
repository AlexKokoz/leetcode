package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000207_CourseSchedule {
	
	// Solution 2
//	@SuppressWarnings("unchecked")
//	public boolean canFinish(int n, int[][] prerequisites) {
//		final Queue<Integer>[] adj = new Queue[n];
//		for (int i = 0; i < n; i++)
//			adj[i] = new LinkedList<>();
//		final List<Integer> bfs = new LinkedList<>();
//		final int[] inDegree = new int[n];
//		for (int[] edge : prerequisites) {
//			adj[edge[1]].add(edge[0]);
//			inDegree[edge[0]]++;
//		}
//		for (int i = 0; i < n; i++) {
//			if (inDegree[i] == 0) bfs.add(i);
//		}
//		for (int v = 0; v < bfs.size(); v++) {
//			for (int w : adj[bfs.get(v)]) {
//				if (--inDegree[w] == 0) bfs.add(w);
//			}
//		}
//		return bfs.size() == n;
//	}
	
	// Solution 1
	@SuppressWarnings("unchecked")
	public boolean canFinish(int n, int[][] prerequisites) {
		final Queue<Integer>[] adj = new Queue[n];
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
		for (int[] edge : prerequisites) {
			adj[edge[1]].add(edge[0]);
		}
		for (int i = 0; i < n; i++) {
			if (adj[i].isEmpty()) continue;
			final boolean[] marked = new boolean[n];
			marked[i] = true;
			if (hasCycle(i,i, marked, adj)) {
				return false; 
			}
		}
		return true;
	}
	
	static boolean hasCycle(int ch, int p, boolean[] marked, Queue<Integer>[] adj) {
		boolean hasCycle = false;
		for (int v : adj[ch]) {
			if (marked[v]) return true;
			marked[v] = true;
			hasCycle |= hasCycle(v, ch, marked, adj);
		}
		marked[ch] = false;
		return hasCycle;
	}
}
