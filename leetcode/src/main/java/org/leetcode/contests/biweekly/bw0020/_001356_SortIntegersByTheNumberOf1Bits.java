package org.leetcode.contests.biweekly.bw0020;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001356_SortIntegersByTheNumberOf1Bits {
	public int[] sortByBits(int[] arr) {
		Integer[] a = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			a[i] = arr[i];
		Arrays.sort(a, new Comparator<Integer>() {
			public int compare(Integer b, Integer c) {
				int cnt1 = Integer.bitCount(b);
				int cnt2 = Integer.bitCount(c);
				if (cnt1 < cnt2)
					return -1;
				if (cnt1 > cnt2)
					return 1;
				if (b < c)
					return -1;
				if (b > c)
					return 1;
				return 0;
			}
		});
		for (int i = 0; i < arr.length; i++)
			arr[i] = a[i];
		return arr;
	}
}
