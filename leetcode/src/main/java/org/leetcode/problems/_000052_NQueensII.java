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
public class _000052_NQueensII {
	public int totalNQueens(int n) {
		int[] ans = new int[1]; // reference for count of distinct solutions(answer)
		int colMask = 0;        // the i-th set bit denotes the i-th column is occupied
		int diagLMask = 0;      // the i-th set bit denotes the i-th left-tilted diagonal is occupied
		int diagRMask = 0;      // the i-th set bit denotes the i-th right-tilted diagonal is occupied
		int[] pos = new int[n]; // pos[i] denotes that a queen is placed on i-th row and pos[i]-th column
		for (int i = 0; i < n; i++)
			pos[i] = i;
		permute(ans, new LinkedList<>(), pos, colMask, diagLMask, diagRMask); // go through permutations
		return ans[0];
	}

	void permute(int[] ans, List<Integer> perm, int[] pos, int colMask, int diagLMask, int diagRMask) {
		
		// A unique permutation is completed; +1 to answer
		if (perm.size() == pos.length) {
			ans[0]++;
			return;
		}
		
		for (int i = 0; i < pos.length; i++) {
			
			// Check if pos[i]-th column is occupied(by checking if i-th bit is set)
			if (colMask << ~pos[i] < 0) 
				continue;
			
			// Calculate the index of candidate queen's coordinates left-tilted diagonal
			int iL = perm.size() + pos[i];
			// Calculate the index of candidate queen's coordinates right-tilted diagonal
			int iR = perm.size() + pos.length - 1 - pos[i];
			// Check if any of the diagonals is occupied(by checking if corresponding bit is set)
			if (diagLMask << ~iL < 0 || diagRMask << ~iR < 0)
				continue;

			// Set queen in i-th row and pos[i]-th column
			perm.add(pos[i]);
			// Mark column, left-tilted diagonal, right-tilted diagonal
			colMask |= (1 << pos[i]);
			diagLMask |= (1 << iL);
			diagRMask |= (1 << iR);
			// Continue with the current permutation
			permute(ans, perm, pos, colMask, diagLMask, diagRMask);
			// Backtrack by de-occupying column, left-tilted diagonal, right-tilted diagonal 
			colMask &= ~(1 << pos[i]);
			diagLMask &= ~(1 << iL);
			diagRMask &= ~(1 << iR);
			// Unset queen in i-th row and pos[i]-th column
			perm.remove(perm.size() - 1);
		}
	}
}
