package org.leetcode.problems;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000204_CountPrimes {
	public int countPrimes(int n) {
		final boolean[] marked = new boolean[n];
		for (int i = 2; i * i < n; i++) {
			if (marked[i])
				continue;
			int k = i * i;
			while (k < n) {
				marked[k] = true;
				k += i;
			}
		}
		int ans = 0;
		for (int i = 2; i < marked.length; i++)
			if (!marked[i])
				ans++;
		return ans;
	}
}
