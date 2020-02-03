package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001344_JumpGameV {

	/*
	 * The strategy is to start from the taller to the shorter indices and keep the
	 * max steps for each so far.
	 */
	public int maxJumps(final int[] arr, int d) {
		int n = arr.length;

		// hi2lo stores all indices 0..n-1 sorted from tallest to shortest
		Integer[] hi2lo = new Integer[n];
		for (int i = 0; i < n; i++)
			hi2lo[i] = i;
		Arrays.sort(hi2lo, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (arr[a] > arr[b])
					return -1;
				if (arr[a] < arr[b])
					return 1;
				return 0;
			}
		});

		// dp[i] denotes the maximum steps we can take up to i.
		int[] dp = new int[n];

		// starting on each index is 1 step on its own
		Arrays.fill(dp, 1);

		for (int from : hi2lo) {

			// go backward
			for (int to = from - 1; to >= 0 && from - d <= to && arr[to] < arr[from]; to--) {
				dp[to] = Math.max(dp[to], dp[from] + 1);
			}

			// go forward
			for (int to = from + 1; to < n && to <= from + d && arr[to] < arr[from]; to++) {
				dp[to] = Math.max(dp[to], dp[from] + 1);
			}
		}

		// the answer is the index with the maximum number of steps so far
		int max = Integer.MIN_VALUE;
		for (int x : arr)
			max = Math.max(max, x);
		return max;
	}
}
