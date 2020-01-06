package org.leetcode.contests.biweekly.bw0016;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001300_SumOfMutatedArrayClosestToTarget {
	public int findBestValue(int[] arr, int target) {
		final int n = arr.length;
		int max = 0;
		int initSum = 0;
		for (int x : arr) {
			max = Math.max(max, x);
			initSum += x;
		}
		if (initSum <= target)
			return max;
		int value = (int) Math.round(target * 1.0 / n);
		int newSum = 0;
		int changed = 0;
		for (int x : arr) {
			if (x < value)
				newSum += x;
			else {
				newSum += value;
				changed++;
			}
		}
		int diff = (int) Math.round((target - newSum) * 1.0 / changed);
		value += diff;
		if (Math.abs(target - newSum + changed * (diff - 1)) <= Math.abs(target - newSum + changed * diff))
			return value - 1;
		else if (Math.abs(target - newSum + changed * diff) <= Math.abs(target - newSum + changed * (diff + 1)))
			return value;
		else
			return value + 1;
	}
}
