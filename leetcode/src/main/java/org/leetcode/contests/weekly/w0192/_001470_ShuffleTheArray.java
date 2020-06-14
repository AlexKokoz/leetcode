package org.leetcode.contests.weekly.w0192;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001470_ShuffleTheArray {
	public int[] shuffle(int[] nums, int n) {
		int[] ans = new int[2 * n];
		for (int i = 0; i < n; i++) {
			ans[2 * i] = nums[i];
			ans[2 * i + 1] = nums[n + i];
		}
		return ans;
	}
}
