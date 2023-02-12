package org.leetcode.contests.weekly.w0227;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001752_CheckIfArrayIsSortedAndRotated {
	public boolean check(int[] nums) {
		int n = nums.length;
		int inv = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] < nums[i - 1])
				inv++;
		}
		if (nums[n - 1] > nums[0])
			inv++;
		return inv <= 1;
	}
}
