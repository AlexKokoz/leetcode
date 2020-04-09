package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000036_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[][] rowseen = new boolean[9][10];
		boolean[][] colseen = new boolean[9][10];
		boolean[][] subboxseen = new boolean[9][10];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				char ch = board[r][c];
				if (ch == '.')
					continue;
				int d = ch - '0';
				int subbox = (r / 3) * 3 + (c / 3);
				if (rowseen[r][d] || colseen[c][d] || subboxseen[subbox][d])
					return false;
				rowseen[r][d] = true;
				colseen[c][d] = true;
				subboxseen[subbox][d] = true;
			}
		}
		return true;
	}
}
