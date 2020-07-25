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
public class _001091_ShortestPathInBinaryMatrix {
	int[] dr8 = new int[] { 1, 1, -1, -1, -1, 0, 1, 0 };
	int[] dc8 = new int[] { 1, -1, 1, -1, 0, 1, 0, -1 };

	public int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		if (grid[0][0] == 1)
			return -1;
		if (n == 1 && m == 1)
			return 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		grid[0][0] = 1;
		int ans = 1;
		while (!q.isEmpty()) {
			ans++;
			for (int i = 0, end = q.size(); i < end; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				for (int j = 0; j < dr8.length; j++) {
					int nr = r + dr8[j];
					int nc = c + dc8[j];
					if (nr < 0 || nc < 0 || nr == n || nc == m || grid[nr][nc] != 0)
						continue;
					if (nr == n - 1 && nc == m - 1)
						return ans;
					q.add(new int[] { nr, nc });
					grid[nr][nc] = 1;
				}
			}
		}
		return -1;
	}
}
