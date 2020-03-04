package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001349_MaximumStudentsTakingExam {
	public int maxStudents(char[][] map) {
		int R = map.length; // number of rows
		int C = map[0].length; // number of columns

		int nStates = 1 << C; // number of possible row states ie (10001010)
		int[] dp = new int[nStates]; // number of valid occupied seats for each state so far
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;

		// from back to front row, since back row doesn't have back row restriction
		for (int row = R - 1; row >= 0; row--) {
			int[] ndp = new int[nStates];
			Arrays.fill(ndp, Integer.MIN_VALUE);

			outer:
			// consider each possible valid state
			for (int curState = 0; curState < nStates; curState++) {

				// reject states with adjacent seats
				int adj = curState & (curState >> 1);
				if (adj > 0)
					continue;

				// if at least one assigned seat is broken, discard current state
				for (int seat = 0; seat < C; seat++) {
					if (curState << ~seat < 0 && map[row][seat] == '#')
						continue outer;
				}

				// consider all previous possible valid states
				for (int prevState = 0; prevState < nStates; prevState++) {

					// reject a previous row state with an occupied seat that can copy from an
					// occupied seat in the current row, from a diagonal position
					int diagonalBack = curState & (prevState << 1 | prevState >> 1);
					if (diagonalBack > 0)
						continue;

					// add current number of occupied seats
					ndp[curState] = Math.max(ndp[curState], dp[prevState] + Integer.bitCount(curState));
				}
			}

			dp = ndp;
		}

		int max = 0;
		for (int x : dp)
			max = Math.max(max, x);
		return max;
	}
}
