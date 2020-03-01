package org.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001368_MinimumCostToMakeAtLeastOneValidPathInAGrid {
	public int minCost(int[][] a) {

		int R = a.length;
		int C = a[0].length;
		int[][] dp = new int[R][C];
		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);
		dp[0][0] = 0;
		int[] dr = new int[] { 1, 0, -1, 0 }; // bottom:cc
		int[] dc = new int[] { 0, 1, 0, -1 }; // bottom:cc
		int[] to = new int[] { -1, 1, 3, 0, 2 }; // map transition arrows to dr, dc
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				if (to[a[r][c]] == i) { // no arrow change
					if (dp[nr][nc] > dp[r][c]) {
						dp[nr][nc] = dp[r][c];
						q.addFirst(new int[] { nr, nc });
					}
				} else { // arrow change
					if (dp[nr][nc] > dp[r][c] + 1) {
						dp[nr][nc] = dp[r][c] + 1;
						q.addLast(new int[] { nr, nc });
					}
				}
			}

		}
		return dp[R - 1][C - 1];
	}
}
