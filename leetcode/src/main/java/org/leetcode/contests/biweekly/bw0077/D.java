package org.leetcode.contests.biweekly.bw0077;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	static int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int maximumMinutes(int[][] grid) {
		int ans = -1;
		int lo = 0;
		int hi = 1000000000;
		int[][] eta = eta(grid);
		while (lo <= hi) {
			int mi = lo + (hi - lo) / 2;
			if (ok(grid, mi, eta)) {
				ans = mi;
				lo = mi + 1;
			} else {
				hi = mi - 1;
			}
		}
		return ans;
	}

	// ETA of fire in a grass cell; Integer.MAX_VALUE for walls and for out of reach
	// grass cells
	int[][] eta(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int[][] eta = new int[n][m];
		Deque<int[]> dq = new ArrayDeque<>();
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (grid[r][c] == 1) {
					dq.add(new int[] { r, c });
					eta[r][c] = 0;
				} else {
					eta[r][c] = -1;
				}
			}
		}
		while (!dq.isEmpty()) {
			for (int i = 0, size = dq.size(); i < size; i++) {
				int node[] = dq.poll(), r = node[0], c = node[1];
				for (int[] d : d4) {
					int nr = r + d[0], nc = c + d[1];
					if (nr < 0 || nc < 0 || nr == n || nc == m || grid[nr][nc] != 0
							|| eta[nr][nc] >= 0)
						continue;
					eta[nr][nc] = eta[r][c] + 1;
					dq.add(new int[] { nr, nc });
				}
			}
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (eta[r][c] == -1)
					eta[r][c] = Integer.MAX_VALUE;
			}
		}
		return eta;

	}

	boolean ok(int[][] grid, int wait, int[][] eta) {
		Deque<int[]> dq = new ArrayDeque<>();
		int n = grid.length, m = grid[0].length;
		dq.add(new int[] { 0, 0, wait });
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		while (!dq.isEmpty()) {
			for (int i = 0, size = dq.size(); i < size; i++) {
				int node[] = dq.poll(), r = node[0], c = node[1], arrival = node[2];
				for (int[] d : d4) {
					int nr = r + d[0], nc = c + d[1];
					if (nr < 0 || nc < 0 || nr == n || nc == m || grid[nr][nc] != 0
							|| visited[nr][nc])
						continue;
					if (nr == n - 1 && nc == m - 1 && arrival + 1 == eta[nr][nc])
						return true;
					if (arrival + 1 >= eta[nr][nc])
						continue;
					dq.add(new int[] { nr, nc, arrival + 1 });
					visited[nr][nc] = true;
				}
			}
		}
		return visited[n - 1][m - 1];
	}
}
