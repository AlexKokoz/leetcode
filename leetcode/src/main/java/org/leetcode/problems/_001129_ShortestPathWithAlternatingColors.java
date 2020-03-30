package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001129_ShortestPathWithAlternatingColors {
	final int RED = 0;
	final int BLUE = 1;

	public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		@SuppressWarnings("unchecked")
		List<Pair<Integer, Integer>>[] adj = new List[n];
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<>();
		for (int[] e : red_edges)
			adj[e[0]].add(new Pair<>(e[1], RED));
		for (int[] e : blue_edges)
			adj[e[0]].add(new Pair<>(e[1], BLUE));
		int[] ans = new int[n];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[0] = 0;
		Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
		for (int i = 0; i < adj[0].size(); i++) {
			Pair<Integer, Integer> ch = adj[0].get(i);
			q.add(new Pair<>(new Pair<>(ch.a, ch.b), 1)); // ((to, color), step)
			adj[0].set(i, null);
		}
		while (!q.isEmpty()) {
			for (int i = 0, len = q.size(); i < len; i++) {
				Pair<Pair<Integer, Integer>, Integer> cur = q.poll();
				int to = cur.a.a;
				int color = cur.a.b;
				int step = cur.b;
				ans[to] = Math.min(ans[to], step);
				for (int j = 0; j < adj[to].size(); j++) {
					Pair<Integer, Integer> nch = adj[to].get(j);
					if (nch == null || (nch.b == RED && color == RED) || (nch.b == BLUE && color == BLUE))
						continue;
					adj[to].set(j, null);
					q.add(new Pair<>(new Pair<>(nch.a, nch.b), step + 1));
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == Integer.MAX_VALUE)
				ans[i] = -1;
		}
		return ans;
	}

	static class Pair<A, B> {
		A a;
		B b;

		public Pair(A to, B color) {
			this.a = to;
			this.b = color;
		}
	}
}
