package org.leetcode.contests.biweekly.bw0071;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[] pivotArray(int[] nums, int pivot) {
		int n = nums.length;
		int[] ans = new int[n];
		Arrays.fill(ans, pivot);
		int lt = 0;
		int eq = 0;
		for (int x : nums) {
			if (x == pivot)
				eq++;
			else if (x < pivot)
				lt++;
		}
		int gt = lt + eq;
		lt = 0;
		for (int x : nums) {
			if (x < pivot) {
				ans[lt++] = x;
			} else if (x > pivot) {
				ans[gt++] = x;
			}
		}
		return ans;
	}
}
