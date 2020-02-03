package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001342_ReduceArraySizeToHalf {
	public int minSetSize(int[] arr) {
		int n = arr.length;
		int half = n / 2;
		int max = 0;
		for (int x : arr)
			max = Math.max(max, x);
		int[] freq = new int[max + 1];
		for (int x : arr)
			freq[x]++;
		Arrays.sort(freq);
		int count = 0;
		int sum = 0;
		for (int i = freq.length - 1; i >= 0; i--) {
			sum += freq[i];
			count++;
			if (sum >= half)
				break;
		}
		return count;
	}
}
