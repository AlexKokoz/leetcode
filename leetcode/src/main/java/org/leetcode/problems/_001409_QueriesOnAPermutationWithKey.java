package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001409_QueriesOnAPermutationWithKey {
	public int[] processQueries(int[] queries, int m) {
		int[] val2ind = new int[m + 1];
		int[] ind2val = new int[m];
		int[] ans = new int[queries.length];
		for (int i = 0; i < m; i++) {
			ind2val[i] = i + 1;
			val2ind[i + 1] = i;
		}

		for (int qi = 0; qi < queries.length; qi++) {
			int q = queries[qi];
			int index = val2ind[q];
			ans[qi] = index;
			for (int i = index - 1; i >= 0; i--) {
				int val = ind2val[i];
				val2ind[val] = i + 1;
				ind2val[i + 1] = val;
			}
			val2ind[q] = 0;
			ind2val[0] = q;
		}
		return ans;
	}
}
