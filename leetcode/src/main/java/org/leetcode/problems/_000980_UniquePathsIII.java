package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000980_UniquePathsIII {
	int ans = 0;
	int[][] dir = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int uniquePathsIII(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		int walkable = 0;
		int r0 = -1;
		int c0 = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] > -1)
					walkable++;
				if (grid[i][j] == 1) {
					r0 = i;
					c0 = j;
				}
			}
		}
		if (r0 < 0)
			return 0;
		visited[r0][c0] = true;
		dfs(r0, c0, grid, visited, walkable - 1);
		return ans;
	}

	void dfs(int r, int c, int[][] grid, boolean[][] visited, int remaining) {
		if (grid[r][c] == 2) {
			if (remaining == 0)
				ans++;
			return;
		}
		for (int[] d : dir) {
			int nr = r + d[0];
			int nc = c + d[1];
			if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] > -1
					&& !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, grid, visited, remaining - 1);
				visited[nr][nc] = false;
			}
		}
	}
}
