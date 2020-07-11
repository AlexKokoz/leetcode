package org.leetcode.contests.biweekly.bw0030;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001508_RangeSumOfSortedSubarraySums {
	public int rangeSum(int[] nums, int n, int left, int right) {
		long mod = 1000000007;
		long[] sums = new long[n * (n + 1) / 2];
		int p = 0;
		for (int i = 0; i < n; i++) {
			int sum  = 0;
			for (int j = i;j < n; j++) { 
				sum += nums[i];
				sums[p++] = sum;
			}
		}
		Arrays.sort(sums);
		System.out.println(Arrays.toString(sums));
		long ans = 0;
		left--;
		right--;
		for (int i = left; i<= right; i++) 
			ans = (ans + sums[i]) % mod;
		
		return (int) ans;
	}
}
