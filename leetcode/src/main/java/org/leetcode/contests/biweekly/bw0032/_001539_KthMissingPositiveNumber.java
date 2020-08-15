package org.leetcode.contests.biweekly.bw0032;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001539_KthMissingPositiveNumber {
	public int findKthPositive(int[] arr, int k) {
		int n = arr.length;
		for (int i = 1, j = 0; i < 2001; i++) {
			while (j < n && arr[j] < i)
				j++;
			if (arr[j] == i) {
				j++;
			} else {
				k--;
			}
			if (k == 0)
				return i;
		}
		return 0;
	}
}
