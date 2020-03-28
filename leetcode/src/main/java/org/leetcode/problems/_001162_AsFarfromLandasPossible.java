package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001162_AsFarfromLandasPossible {
	public int maxDistance(int[][] g) {
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int n = g.length;
		int[][] dist = new int[n][n];
		Queue<Pair> q = new LinkedList<>();
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (g[r][c] == 1) {
					q.add(new Pair(r, c));
					dist[r][c] = 0;
				} else {
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
		}
		while (!q.isEmpty()) {
			for (int i = 0, len = q.size(); i < len; i++) {
				Pair cur = q.poll();
				for (int d = 0; d < dr.length; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					if (nr < 0 || nc < 0 || nr == n || nc == n || g[nr][nc] == 1)
						continue;
					if (dist[nr][nc] > dist[cur.r][cur.c] + 1) {
						dist[nr][nc] = dist[cur.r][cur.c] + 1;
						q.add(new Pair(nr, nc));
					}
				}
			}
		}
		int max = -1;
		for (int[] row : dist)
			for (int d : row)
				max = Math.max(max, d);
		return max == Integer.MAX_VALUE || max == 0 ? -1 : max;
	}

	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
