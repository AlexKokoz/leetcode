package org.leetcode.contests.weekly.w0193;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001480_LeastNumberOfUniqueIntegersAfterKRemovals {
	public int findLeastNumOfUniqueInts(int[] nums, int k) {
		Arrays.sort(nums);
		int[] f = countUnique(nums);
		Arrays.sort(f);
		int p = 0;
		while (k > 0) {
			k = k - f[p];
			if (k < 0)
				break;
			p++;
		}
		return f.length - p;
	}

	int[] countUnique(int[] sorted) { // array is assumed to be sorted
		int n = sorted.length;
		int[] uniq = new int[n];
		int p = 0;
		int prev = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (sorted[i] != prev)
				p++;
			uniq[p - 1]++;
			prev = sorted[i];
		}
		return Arrays.copyOf(uniq, p);
	}
}
