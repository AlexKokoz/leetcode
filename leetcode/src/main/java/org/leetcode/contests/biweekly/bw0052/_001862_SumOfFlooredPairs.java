package org.leetcode.contests.biweekly.bw0052;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001862_SumOfFlooredPairs {
	public int sumOfFlooredPairs(int[] nums) {
		long mod = 1000000007;
		int max = 0;
		for (int x : nums)
			max = Math.max(max, x);
		int[] times = new int[max + 1];
		Arrays.sort(nums);
		int[][] counter = counter(nums);
		for (int[] node : counter) {
			int cur = node[0];
			int f = node[1];
			times[cur] += f;
			for (int j = cur << 1; j <= max; j += cur) {
				times[j] += f;
			}
		}
		int ic = 0;
		long ans = 0;
		long pref = 0;
		for (int i = 1; i < times.length && ic < counter.length; i++) {
			pref += times[i];
			if (i == counter[ic][0]) {
				ans = (ans + pref * counter[ic][1]) % mod;
				ic++;
			}
		}
		return (int) ans;
	}

	// Consequtive element count of an int array; each count is denoted as {element,
	// count}
	public static int[][] counter(int[] a) {
		int n = a.length, p = 0;
		int[][] b = new int[n][];
		for (int i = 0; i < n; i++) {
			if (i == 0 || a[i] != a[i - 1])
				b[p++] = new int[] { a[i], 0 };
			b[p - 1][1]++;
		}
		return Arrays.copyOf(b, p);
	}
}
