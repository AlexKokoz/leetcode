package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000079_WordSearch {
	int[] dr = new int[] { 1, 0, -1, 0 };
	int[] dc = new int[] { 0, 1, 0, -1 };

	public boolean exist(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		boolean[][] seen = new boolean[n][m];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (backtrack(r, c, board, seen, word, 0))
					return true;
			}
		}
		return false;
	}

	boolean backtrack(int r, int c, char[][] board, boolean[][] seen, String word, int d) {
		if (r < 0 || c < 0 || r == board.length || c == board[0].length || seen[r][c])
			return false;
		if (d == word.length())
			return true;
		if (board[r][c] != word.charAt(d))
			return false;
		seen[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (backtrack(nr, nc, board, seen, word, d + 1))
				return true;
		}
		seen[r][c] = false;
		return false;
	}
}
