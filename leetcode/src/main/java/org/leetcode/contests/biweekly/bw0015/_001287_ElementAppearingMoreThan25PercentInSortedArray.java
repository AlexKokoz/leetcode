package org.leetcode.contests.biweekly.bw0015;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001287_ElementAppearingMoreThan25PercentInSortedArray {

	public int findSpecialInteger(int[] arr) {
		final int n = arr.length;
		final double q = n / 4.0;
		int start = 0;
		int i = 1;
		if (n == 1)
			return arr[0];
		;
		while (i < n) {
			while (i < n && arr[i] == arr[i - 1])
				i++;
			if (i - start > q)
				return arr[start];
			start = i;
			i++;
		}
		return -1;
	}

}
