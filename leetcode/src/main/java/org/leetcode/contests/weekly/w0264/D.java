package org.leetcode.contests.weekly.w0264;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public int minimumTime(int n, int[][] rs, int[] time) {
		int nr = rs.length;
		int[] from = new int[nr];
		int[] to = new int[nr];
		int[] indeg = new int[n];
		for (int i = 0; i < nr; i++) {
			from[i] = rs[i][0] - 1;
			to[i] = rs[i][1] - 1;
			indeg[rs[i][1] - 1]++;
		}
		int[][] adj = packD(n, from, to);
		int[] anss = new int[n];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indeg[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nei : adj[cur]) {
				anss[nei] = Math.max(anss[nei], anss[cur] + time[cur]);
				indeg[nei]--;
				if (indeg[nei] == 0) {
					q.add(nei);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, anss[i]);
			if (adj[i].length == 0) {
				ans = Math.max(ans, anss[i] + time[i]);
			}
		}
		return ans;
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
