package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000055_JumpGame {
	public boolean canJump(int[] nums) {
		int n = nums.length;
		int farthest = 0;
		for (int i = 0; i < n; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i < n - 1 && i == farthest)
				return false;
		}
		return true;
	}
}
