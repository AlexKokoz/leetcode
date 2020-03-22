package org.leetcode.contests.biweekly.bw0022;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001387_SortIntegersbyThePowerValue {
	public int getKth(int lo, int hi, int k) {
		int[][] arr = new int[hi - lo + 1][2];
		for (int i = 0; i < arr.length; i++)
			arr[i][0] = lo + i;
		for (int i = 0; i < arr.length; i++) {
			int cur = lo + i;
			arr[i][1] = power(cur);
			int j = cur << 1;
			while (j < arr.length) {
				arr[j][1] = arr[j >> 1][1] + 1;
				j <<= 1;
			}
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (b[0] < lo || b[0] > hi)
					return -1;
				if (a[0] < lo || a[0] > hi)
					return 1;
				return a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : 0;
			}
		});
		return arr[k - 1][0];
	}

	int power(int n) {
		int p = 0;
		while (n > 1) {
			if ((n & 1) == 0) // even
				n >>= 1;
			else // odd
				n = 3 * n + 1;
			p++;
		}
		return p;
	}
}
