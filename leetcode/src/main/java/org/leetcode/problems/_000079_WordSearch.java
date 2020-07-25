package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000079_WordSearch {
	int[] dr4 = { 1, 0, -1, 0 };
	int[] dc4 = { 0, 1, 0, -1 };
	boolean ans;

	public boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		boolean[][] seen = new boolean[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				dfs(r, c, board, word, 0, seen);
				if (ans)
					return true;
			}
		}
		return false;
	}

	void dfs(int r, int c, char[][] board, String word, int d, boolean[][] seen) {
		if (ans || seen[r][c] || board[r][c] != word.charAt(d))
			return;
		if (d == word.length() - 1) {
			ans = true;
			return;
		}
		seen[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr4[i];
			int nc = c + dc4[i];
			if (nr < 0 || nc < 0 || nr == board.length || nc == board[0].length)
				continue;
			dfs(nr, nc, board, word, d + 1, seen);
		}
		seen[r][c] = false;
	}
}
