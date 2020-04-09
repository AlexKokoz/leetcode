package org.leetcode.problems;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000033_SearchInRotatedSortedArray {
	public int search(int[] a, int x) {
		final int n = a.length;
		if (n == 0)
			return -1;
		int lo = 0;
		int hi = n - 1;

		while (lo <= hi) {
			final int mi = lo + (hi - lo) / 2;
			if (x < a[mi]) {
				if (a[mi] > a[n - 1] && x <= a[n - 1])
					lo = mi + 1;
				else
					hi = mi - 1;
			} else if (a[mi] < x) {
				if (a[mi] < a[0] && x >= a[0])
					hi = mi - 1;
				else
					lo = mi + 1;

			} else
				return mi;
		}
		return -1;
	}
}
