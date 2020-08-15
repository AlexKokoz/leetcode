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
public class _000994_RottingOranges {

	public int orangesRotting(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int ans = 0;
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<>();
		int oranges = 0;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (grid[r][c] == 1) {
					oranges++;
				} else if (grid[r][c] == 2) {
					q.add(new int[] { r, c });
				}
			}
		}
		if (oranges == 0)
			return 0;
		while (!q.isEmpty()) {
			boolean changed = false;
			for (int i = 0, len = q.size(); i < len; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				for (int j = 0; j < 4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length
							&& grid[nr][nc] == 1) {
						grid[nr][nc] = 2;
						q.add(new int[] { nr, nc });
						oranges--;
						changed = true;
					}
				}
			}
			if (changed)
				ans++;
		}
		return oranges == 0 ? ans : -1;
	}
}
