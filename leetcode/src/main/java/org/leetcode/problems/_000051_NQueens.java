package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000051_NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new LinkedList<>();
		boolean[] chosen = new boolean[n];
		boolean[] diagL = new boolean[(n - 1) + (n - 1) + 1];
		boolean[] diagR = new boolean[diagL.length];
		int[] pos = new int[n];
		for (int i = 0; i < n; i++)
			pos[i] = i;
		backtrack(ans, new LinkedList<>(), pos, chosen, diagL, diagR);
		return ans;
	}

	void backtrack(List<List<String>> ans, List<Integer> placements, int[] pos, boolean[] chosen, boolean[] diagL,
			boolean[] diagR) {
		if (placements.size() == pos.length) {
			ans.add(printBoard(placements));
			return;
		}

		for (int i = 0; i < pos.length; i++) {
			if (chosen[pos[i]])
				continue;
			int iL = placements.size() + pos[i];
			int iR = placements.size() + (pos.length - 1 - pos[i]);
			if (diagL[iL] || diagR[iR])
				continue;

			placements.add(pos[i]);
			chosen[pos[i]] = true;
			diagL[iL] = true;
			diagR[iR] = true;
			backtrack(ans, placements, pos, chosen, diagL, diagR);
			placements.remove(placements.size() - 1);
			chosen[pos[i]] = false;
			diagL[iL] = false;
			diagR[iR] = false;
		}
	}

	List<String> printBoard(List<Integer> placements) {
		int n = placements.size();
		List<String> board = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (placements.get(i) == j)
					sb.append('Q');
				else
					sb.append('.');
			}
			board.add(sb.toString());
		}
		return board;
	}
}
