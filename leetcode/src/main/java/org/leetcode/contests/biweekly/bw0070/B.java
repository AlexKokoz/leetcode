package org.leetcode.contests.biweekly.bw0070;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int numberOfArrays(int[] differences, int lower, int upper) {
		int n = differences.length;
		int[] a = new int[n + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			a[i + 1] = a[i] + differences[i];
		}
		for (int x : a)
			min = Math.min(min, x);
		int diff = lower - min;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n + 1; i++) {
			a[i] += diff;
			if (a[i] < lower || a[i] > upper)
				return 0;
			max = Math.max(max, a[i]);
		}
		return upper - max + 1;
	}
}
