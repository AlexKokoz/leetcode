package org.leetcode.contests.biweekly.bw0040;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001671_MinimumNumberOfRemovalsToMakeMountainArray {
	// LIS
	public int minimumMountainRemovals(int[] nums) {
		int n = nums.length;
		int[] dpl, dpr;
		
		// Longest INcreasing Subsequence[left -> right]
		dpl = new int[n];
		Arrays.fill(dpl, 1);
		dpl[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dpl[i] = Math.max(dpl[i], dpl[j] + 1);
				}
			}
		}

		// Longest INcreasing Subsequence[right -> left]
		dpr = new int[n];
		Arrays.fill(dpr, 1);
		dpr[n - 1] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (nums[i] > nums[j]) {
					dpr[i] = Math.max(dpr[i], dpr[j] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i < n - 1; i++) {
			max = Math.max(max, dpl[i] + dpr[i] - 1);
		}

		return n - max;
	}
}
