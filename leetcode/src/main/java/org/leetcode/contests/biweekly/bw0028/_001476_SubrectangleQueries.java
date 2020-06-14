package org.leetcode.contests.biweekly.bw0028;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001476_SubrectangleQueries {

	class SubrectangleQueries {
		int[][] mat;
		Deque<int[]> history;

		public SubrectangleQueries(int[][] mat) {
			this.mat = mat;
			history = new ArrayDeque<>();
		}

		public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
			history.addFirst(new int[] { row1, col1, row2, col2, newValue });
		}

		public int getValue(int row, int col) {
			for (int[] change : history) {
				if (change[0] <= row && change[1] <= col && row <= change[2] && col <= change[3]) {
					return change[4];
				}
			}
			return mat[row][col];
		}
	}
}
