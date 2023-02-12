package org.leetcode.contests.weekly.w0324;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] maxPoints(int[][] grid, int[] queries) {
		int nq = queries.length;
		int n = grid.length;
		int m = grid[0].length;
		int[][] qi = new int[nq][];
		for (int i = 0; i < nq; i++) {
			qi[i] = new int[] { queries[i], i };
		}
		Arrays.sort(qi, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});
		int[] ans = new int[nq];

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[0], b[0]);
		});

		pq.add(new int[] { grid[0][0], 0, 0 });

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		for (int i = 0; i < nq; i++) {
			int cur = qi[i][0];
			int index = qi[i][1];
			int addedScore = 0;

			while (!pq.isEmpty() && pq.peek()[0] < cur) {
				int node[] = pq.poll(), r = node[1], c = node[2];
				addedScore += 1;
				for (int[] d : d4) {
					int nr = r + d[0], nc = c + d[1];
					if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc]) {
						pq.add(new int[] { grid[nr][nc], nr, nc });
						visited[nr][nc] = true;
					}
				}
			}

			ans[index] = (i > 0 ? ans[qi[i - 1][1]] : 0) + addedScore;
		}

		return ans;
	}
}
