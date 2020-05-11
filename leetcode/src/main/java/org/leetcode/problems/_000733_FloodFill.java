package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000733_FloodFill {
	int[] dr = new int[] { 1, 0, -1, 0 };
	int[] dc = new int[] { 0, 1, 0, -1 };

	public int[][] floodFill(int[][] image, int r, int c, int newColor) {
		int n = image.length;
		int m = image[0].length;
		if (image[r][c] != newColor)
			dfs(r, c, n, m, image, image[r][c], newColor);
		return image;
	}

	void dfs(int r, int c, int n, int m, int[][] image, int oldColor, int newColor) {
		if (r < 0 || c < 0 || r == n || c == m || image[r][c] != oldColor) {
			return;
		}
		image[r][c] = newColor;
		for (int dir = 0; dir < dr.length; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			dfs(nr, nc, n, m, image, oldColor, newColor);
		}
	}
}
