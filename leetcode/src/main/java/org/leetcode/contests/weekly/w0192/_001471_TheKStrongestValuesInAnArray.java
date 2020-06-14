package org.leetcode.contests.weekly.w0192;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001471_TheKStrongestValuesInAnArray {
	public int[] getStrongest(int[] arr, int k) {
		int n = arr.length;
		Integer[] cp = new Integer[n];
		for (int i = 0; i < n; i++) cp[i] = arr[i];
		Arrays.sort(cp);
		int median = cp[(cp.length - 1) / 2];

		Arrays.sort(cp, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				int x1 = Math.abs(a - median);
				int x2 = Math.abs(b - median);
				if (x1 != x2) return x2 - x1;
				return b - a;
			}
		});
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) ans[i] = cp[i];
		return ans;
	}
}
