package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000060_PermutationSequence {

	public String getPermutation(int n, int k) {
		int[] pow = new int[n + 1];
		pow[0] = 1;
		for (int i = 1; i <= n; i++)
			pow[i] = pow[i - 1] * i;
		boolean[] used = new boolean[n + 1];

		StringBuilder sb = new StringBuilder();
		for (int i = n; i >= 1; i--) {
			int j = (int) Math.ceil((double) k / pow[i - 1]);
			int elem = get(used, j);
			used[elem] = true;
			sb.append(elem);
			k = k - (j - 1) * pow[i - 1];
		}
		return sb.toString();
	}

	// get j-th not-used number in [1..n]
	static int get(boolean[] used, int j) {
		for (int i = 1; i < used.length; i++) {
			if (!used[i])
				j--;
			if (j == 0)
				return i;
		}
		return 0;
	}
}
