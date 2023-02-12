package org.leetcode.contests.biweekly.bw0043;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001718_ConstructTheLexicographicallyLargestValidSequence {

	public int[] constructDistancedSequence(int n) {
		return dfs(0, new int[2 * n - 1], 0, n);
	}

	int[] dfs(int d, int[] a, int mask, int n) {
		if (d == a.length) {
			return a;
		}
		if (a[d] > 0)
			return dfs(d + 1, a, mask, n);
		for (int cand = n; cand > 0; cand--) {
			if (mask << ~cand < 0)
				continue;
			if (cand == 1) {
				a[d] = cand;
				int[] ret = dfs(d + 1, a, mask ^ (1 << cand), n);
				if (ret != null)
					return ret;
				a[d] = 0;
			} else {
				if (d + cand >= a.length || a[d + cand] > 0)
					continue;
				a[d] = cand;
				a[d + cand] = cand;
				int[] ret = dfs(d + 1, a, mask ^ (1 << cand), n);
				if (ret != null)
					return ret;
				a[d] = 0;
				a[d + cand] = 0;
			}
		}
		return null;
	}
}
