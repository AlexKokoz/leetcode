package org.leetcode.contests.weekly.w0167;

import java.util.LinkedList;
import java.util.Queue;

/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001293_ShortestPathGridObstaclesElimination {

	public int shortestPath(int[][] grid, int k) {
		final int R = grid.length;
		final int C = grid[0].length;
		if (R == 1 && C == 1)
			return 0;
		final boolean[][] marked = new boolean[R][C];
		final int[][] helps = new int[R][C];
		final Queue<int[]> q = new LinkedList<>();
		final int[] elem = new int[4];
		elem[0] = 0; // r
		elem[1] = 0; // c
		elem[2] = 0; // step
		elem[3] = 0; // help
		q.add(elem);
		marked[0][0] = true;
		helps[0][0] = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int step = cur[2];
			int help = cur[3];
			int[] next;
			for (int i = -1; i <= 1; i += 2) {
				next = new int[4];
				int nr = r + i;
				if (nr < 0 || nr >= R)
					continue;
				if (marked[nr][c] && helps[nr][c] <= help)
					continue;
				if (grid[nr][c] == 1 && help >= k)
					continue;
				next[0] = nr;
				next[1] = c;
				if (nr == R - 1 && c == C - 1)
					return step + 1;
				next[2] = step + 1;
				next[3] = (grid[nr][c] == 1 ? help + 1 : help);
				q.add(next);
				marked[nr][c] = true;
				helps[nr][c] = next[3];
			}

			for (int i = -1; i <= 1; i += 2) {

				next = new int[4];
				int nc = c + i;
				if (nc < 0 || nc >= C)
					continue;
				if (marked[r][nc] && helps[r][nc] <= help)
					continue;
				if (grid[r][nc] == 1 && help >= k)
					continue;
				next[0] = r;
				next[1] = nc;
				if (r == R - 1 && nc == C - 1)
					return step + 1;
				next[2] = step + 1;
				next[3] = (grid[r][nc] == 1 ? help + 1 : help);
				q.add(next);
				marked[r][nc] = true;
				helps[r][nc] = next[3];
			}
		}

		return -1;
	}

}
