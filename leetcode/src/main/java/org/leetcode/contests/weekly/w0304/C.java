package org.leetcode.contests.weekly.w0304;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	static int inf = Integer.MAX_VALUE / 2;

	public int closestMeetingNode(int[] edges, int node1, int node2) {
		int n = edges.length;
		int ans = inf;
		int minMaxDist = inf;
		int[] dist1 = bfs(node1, edges);
		int[] dist2 = bfs(node2, edges);
		for (int i = 0; i < n; i++) {
			int max = Math.max(dist1[i], dist2[i]);
			if (max < minMaxDist) {
				ans = i;
				minMaxDist = max;
			} else if (max != inf && max == minMaxDist) {
				ans = Math.min(ans, i);
			}
		}
		return ans == inf ? -1 : ans;
	}

	int[] bfs(int node, int[] edges) {
		int n = edges.length;
		int[] dist = new int[n];
		Arrays.fill(dist, inf);
		dist[node] = 0;
		Deque<Integer> q = new ArrayDeque<>();
		q.add(node);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (edges[cur] != -1 && dist[edges[cur]] > dist[cur] + 1) {
				dist[edges[cur]] = dist[cur] + 1;
				q.add(edges[cur]);
			}
		}
		return dist;
	}
}
