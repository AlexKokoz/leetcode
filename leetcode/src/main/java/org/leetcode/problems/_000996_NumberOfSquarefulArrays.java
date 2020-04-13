package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000996_NumberOfSquarefulArrays {
	int count;

	public int numSquarefulPerms(int[] A) {
		int n = A.length;
		if (n == 1)
			return 0;
		Arrays.sort(A);
		boolean[] chosen = new boolean[n];
		List<Integer> perm = new LinkedList<>();
		count = 0;
		backtrack(perm, A, chosen);
		return count;
	}

	void backtrack(List<Integer> perm, int[] A, boolean[] chosen) {
		if (perm.size() == A.length) // valid permutation completed
			count++;
		else {
			int last = -1;
			for (int i = 0; i < A.length; i++) {
				if (chosen[i]) // already in the permutation
					continue;
				if (A[i] == last) // to avoid duplicate permutations
					continue;
				last = A[i];
				perm.add(A[i]);
				chosen[i] = true;
				int n = perm.size();
				if (!(n > 1 && !isPerfectSquare(perm.get(n - 1) + perm.get(n - 2)))) // proceed  only if last pair is valid
					backtrack(perm, A, chosen);
				chosen[i] = false;
				perm.remove(n - 1);
			}
		}
	}

	boolean isPerfectSquare(int num) {
		int sqrt = (int) Math.sqrt(num);
		return sqrt * sqrt == num;
	}
}
