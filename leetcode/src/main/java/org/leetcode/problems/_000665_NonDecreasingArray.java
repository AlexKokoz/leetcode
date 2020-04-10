package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000665_NonDecreasingArray {
	public boolean checkPossibility(int[] nums) {
		final int n = nums.length;
		int count = 0;
		for (int i = 0; i < n - 1; i ++) {
			if (nums[i] < nums[i+1]) {
				count++;
				if (i > 0 &&  nums[i+1] < nums[i-1]) {
					nums[i+1] = nums[i];
				}
			}
			if (count > 1) return false;
		}
		return true;
	}
}
