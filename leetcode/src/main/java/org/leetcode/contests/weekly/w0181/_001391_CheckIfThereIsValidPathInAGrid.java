package org.leetcode.contests.weekly.w0181;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001391_CheckIfThereIsValidPathInAGrid {
	int lr = 1;
	int tb = 2;
	int lb = 3;
	int rb = 4;
	int lt = 5;
	int rt = 6;

	public boolean hasValidPath(int[][] grid) {
		return dfs(0, 0, grid);
	}

	boolean dfs(int r, int c, int[][] g) {
		if (r == g.length - 1 && c == g[0].length - 1)
			return true;
		if (g[r][c] < 0)
			return false;
		int dir = g[r][c];
		g[r][c] = -1;
		boolean found = false;
		if (dir == lr) {
			if (c > 0 && g[r][c - 1] > 0 && (g[r][c - 1] == lr || g[r][c - 1] == rb || g[r][c - 1] == rt))
				found |= dfs(r, c - 1, g);
			if (c < g[0].length - 1 && g[r][c + 1] > 0 && (g[r][c + 1] == lr || g[r][c + 1] == lb || g[r][c + 1] == lt))
				found |= dfs(r, c + 1, g);
		} else if (dir == tb) {
			if (r > 0 && g[r - 1][c] > 0 && (g[r - 1][c] == tb || g[r - 1][c] == lb || g[r - 1][c] == rb))
				found |= dfs(r - 1, c, g);
			if (r < g.length - 1 && g[r + 1][c] > 0 && (g[r + 1][c] == tb || g[r + 1][c] == lt || g[r + 1][c] == rt))
				found |= dfs(r + 1, c, g);
		} else if (dir == lb) {
			if (c > 0 && g[r][c - 1] > 0 && (g[r][c - 1] == lr || g[r][c - 1] == rb || g[r][c - 1] == rt))
				found |= dfs(r, c - 1, g);
			if (r < g.length - 1 && g[r + 1][c] > 0 && (g[r + 1][c] == tb || g[r + 1][c] == lt || g[r + 1][c] == rt))
				found |= dfs(r + 1, c, g);
		} else if (dir == rb) {
			if (c < g[0].length - 1 && g[r][c + 1] > 0 && (g[r][c + 1] == lr || g[r][c + 1] == lb || g[r][c + 1] == lt))
				found |= dfs(r, c + 1, g);
			if (r < g.length - 1 && g[r + 1][c] > 0 && (g[r + 1][c] == tb || g[r + 1][c] == lt || g[r + 1][c] == rt))
				found |= dfs(r + 1, c, g);
		} else if (dir == lt) {
			if (c > 0 && g[r][c - 1] > 0 && (g[r][c - 1] == lr || g[r][c - 1] == rb || g[r][c - 1] == rt))
				found |= dfs(r, c - 1, g);
			if (r > 0 && g[r - 1][c] > 0 && (g[r - 1][c] == tb || g[r - 1][c] == lb || g[r - 1][c] == rb))
				found |= dfs(r - 1, c, g);
		} else if (dir == rt) {
			if (c < g[0].length - 1 && g[r][c + 1] > 0 && (g[r][c + 1] == lr || g[r][c + 1] == lb || g[r][c + 1] == lt))
				found |= dfs(r, c + 1, g);
			if (r > 0 && g[r - 1][c] > 0 && (g[r - 1][c] == tb || g[r - 1][c] == lb || g[r - 1][c] == rb))
				found |= dfs(r - 1, c, g);
		}
		return found;
	}
}
