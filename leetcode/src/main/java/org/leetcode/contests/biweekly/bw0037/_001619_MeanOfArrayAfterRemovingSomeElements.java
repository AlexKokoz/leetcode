package org.leetcode.contests.biweekly.bw0037;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001619_MeanOfArrayAfterRemovingSomeElements {
	public double trimMean(int[] arr) {
		int n = arr.length;
		double sum = 0;
		int per5 = n / 20;
		Arrays.sort(arr);
		for(int i = per5; i < n - per5; i++)
			sum += arr[i];
		return sum / (n - 2 * per5);
	}
}
