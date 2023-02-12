package org.leetcode.contests.biweekly.bw0067;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int[] maxSubsequence(int[] nums, int k) {
		int n = nums.length;
		int[][] ai = new int[n][];
		for (int i = 0; i < n; i++) {
			ai[i] = new int[] { nums[i], i };
		}
		Arrays.sort(ai, (a, b) -> {
			return Integer.compare(b[0], a[0]);
		});
		ai = Arrays.copyOf(ai, k);
		int[] ans = new int[k];
		Arrays.sort(ai, (a, b) -> a[1] - b[1]);
		for (int i = 0; i < k; i++) {
			ans[i] = ai[i][0];
		}
		return ans;
	}
}
