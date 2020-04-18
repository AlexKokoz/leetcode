package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000529_MineSweeper {
	private static final char EMPTY = 'E'; // denotes an unrevealed blank tile
	private static final char BLANK = 'B'; // denotes a revealed empty tile with no adjacent mines
	private static final char MINE = 'M'; // denotes an unrevealed mine
	private static final char GAME_OVER = 'X'; // denotes an unrevealed mine tile

	public char[][] updateBoard(char[][] board, int[] click) {
		click(click[0], click[1], board);
		return board;
	}

	static void click(int r, int c, char[][] b) {

		/* Clicked on a mine; update board and terminate. */
		if (b[r][c] == MINE) {
			b[r][c] = GAME_OVER;
			return;
		}

		/* Clicked on an already revealed tile; return. */
		if (b[r][c] != EMPTY)
			return;

		final int mineCount = countAdjacentMines(r, c, b);

		/* Empty tile found with no adjacent mines; recurse for its adjacent cells. */
		if (mineCount == 0) {
			b[r][c] = BLANK;
			for (int ir = -1; ir <= 1; ir++) {
				for (int ic = -1; ic <= 1; ic++) {
					if (ir == ic && ir == 0) // avoid checking current center square
						continue;
					if (r + ir < 0 || c + ic < 0 || r + ir >= b.length || c + ic >= b[0].length) // check bounds
						continue;
					if (b[r + ir][c + ic] != EMPTY) // consider only empty tiles
						continue;
					click(r + ir, c + ic, b); // click adjacent tile
				}
			}
		}
		/*
		 * Tile adjacent to at least one mine; update with adjacent mine count and stop
		 * recursion.
		 */
		else {
			b[r][c] = (char) ('0' + mineCount);
		}
	}

	static int countAdjacentMines(int r, int c, char[][] board) {
		int count = 0;
		for (int ir = -1; ir <= 1; ir++)
			for (int ic = -1; ic <= 1; ic++)
				if (ir == ic && ir == 0)
					continue;
				else if (r + ir < 0 || c + ic < 0 || r + ir >= board.length || c + ic >= board[0].length)
					continue;
				else
					count += (board[r + ir][c + ic] == MINE ? 1 : 0);
		return count;
	}

}
