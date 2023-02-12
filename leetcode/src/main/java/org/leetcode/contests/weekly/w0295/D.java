package org.leetcode.contests.weekly.w0295;

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
public class D {
	static int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int minimumObstacles(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int[][] best = new int[n][m];
		for (int[] row : best)
			Arrays.fill(row, Integer.MAX_VALUE / 2);
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { 0, 0 });
		best[0][0] = 0;
		while (!dq.isEmpty()) {
			int node[] = dq.poll(), r = node[0], c = node[1];
			for (int[] d : d4) {
				int nr = r + d[0], nc = c + d[1];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (grid[nr][nc] == 0) {
					if (best[nr][nc] > best[r][c]) {
						best[nr][nc] = best[r][c];
						dq.addFirst(new int[] { nr, nc });
					}
				} else {
					if (best[nr][nc] > best[r][c] + 1) {
						best[nr][nc] = best[r][c] + 1;
						dq.addLast(new int[] { nr, nc });
					}
				}
			}
		}
		return best[n - 1][m - 1];

	}
}
