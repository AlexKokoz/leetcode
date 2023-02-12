package org.leetcode.contests.biweekly.bw0051;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001846_MaximumElementAfterDecreasingAndRearranging {
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.min(arr[i], prev + 1);
			prev = arr[i];
		}
		return arr[arr.length - 1];
	}
}
