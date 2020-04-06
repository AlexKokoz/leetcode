package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000034_FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] a, int x) {
		final int n = a.length;
		final int[] ans = { -1, -1 };
		int lo = 0;
		int hi = n - 1;
		while (lo <= hi) {
			final int mi = lo + (hi - lo) / 2;
			if (x < a[mi]) {
				hi = mi - 1;
			} else if (a[mi] < x) {
				lo = mi + 1;
			} else {
				ans[0] = mi;
				hi = mi - 1;
			}
		}

		lo = 0;
		hi = n - 1;
		while (lo <= hi) {
			final int mi = lo + (hi - lo) / 2;
			if (x < a[mi]) {
				hi = mi - 1;
			} else if (a[mi] < x) {
				lo = mi + 1;
			} else {
				ans[1] = mi;
				lo = mi + 1;
			}
		}

		return ans;
	}
}
