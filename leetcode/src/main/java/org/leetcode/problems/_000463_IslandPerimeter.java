package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000463_IslandPerimeter {
	int ans;
	int[] dr = new int[] { 1, 0, -1, 0 };
	int[] dc = new int[] { 0, 1, 0, -1 };

	public int islandPerimeter(int[][] grid) {
		ans = 0;
		int n = grid.length;
		if (n == 0)
			return 0;
		int m = grid[0].length;
		if (m == 0)
			return 0;
		for (int c = 0; c < m; c++) {
			dfs(0, c, grid, n, m);
			dfs(n - 1, c, grid, n, m);
		}
		for (int r = 0; r < n; r++) {
			dfs(r, 0, grid, n, m);
			dfs(r, m - 1, grid, n, m);
		}
		return ans;
	}

	void dfs(int r, int c, int[][] grid, int n, int m) {
		if (r < 0 || c < 0 || r == n || c == m || grid[r][c] == 2) {
			return;
		}
		if (grid[r][c] == 1) {
			ans++;
		} else if (grid[r][c] == 0) {
			grid[r][c] = 2;
			for (int dir = 0; dir < dr.length; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				dfs(nr, nc, grid, n, m);
			}
		}
	}
}
