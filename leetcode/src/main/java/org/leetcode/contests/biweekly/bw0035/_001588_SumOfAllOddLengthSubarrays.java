package org.leetcode.contests.biweekly.bw0035;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001588_SumOfAllOddLengthSubarrays {
	public int sumOddLengthSubarrays(int[] arr) {
		int sum = 0;
		int n = arr.length;
		for (int len = 1; len <= n; len += 2) {
			for (int l = 0; l <= n - len; l++) {
				int r = l + len - 1;
				for (int i = l; i <= r; i++) {
					sum += arr[i];
				}
			}
		}
		return sum;
	}
}
