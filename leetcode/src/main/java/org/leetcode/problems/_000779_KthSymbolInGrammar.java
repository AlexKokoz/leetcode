package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000779_KthSymbolInGrammar {
	public int kthGrammar(int N, int K) {
		return recurse(K - 1, 0) ? 0 : 1;
	}

	boolean recurse(int i, int val) {
		if (i == 0)
			return val == 0;
		boolean even = (i & 1) == 0;
		int par = i >> 1;
		if (even) {
			if (val == 0)
				return recurse(par, 0);
			else
				return recurse(par, 1);
		} else {
			if (val == 0)
				return recurse(par, 1);
			else
				return recurse(par, 0);
		}
	}
}
