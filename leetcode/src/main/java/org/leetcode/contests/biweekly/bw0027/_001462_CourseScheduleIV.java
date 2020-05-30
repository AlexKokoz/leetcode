package org.leetcode.contests.biweekly.bw0027;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001462_CourseScheduleIV {
	@SuppressWarnings("unchecked")
	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
		Queue<Integer>[] adj = new Queue[n];
		boolean[][] visits = new boolean[n][n];
		
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
		for (int[] e : prerequisites) {
			adj[e[0]].add(e[1]);
		}
		
		for (int i = 0; i < n; i++) {
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			while(!q.isEmpty()) {
				int cur = q.poll();
				visits[i][cur] = true;
				for (int nei : adj[cur]) {
					if (!visits[i][nei]) {
						q.add(nei);
						visits[i][nei] = true;
					}
				}
			}
		}
		List<Boolean> ans = new LinkedList<>();
		for (int[] q : queries) {
			int from = q[0];
			int to = q[1];
			if (visits[from][to]) ans.add(true);
			else ans.add(false);
		}
		return ans;
 	}
}
