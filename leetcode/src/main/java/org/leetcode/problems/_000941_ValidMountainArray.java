package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000941_ValidMountainArray {
	public boolean validMountainArray(int[] nums) {
		int n = nums.length;
		if (n < 3)
			return false;

		int left = 0;
		while (left < n - 1 && nums[left] < nums[left + 1])
			left++;
		if (left == 0)
			return false;

		int right = n - 1;
		while (right > 0 && nums[right] < nums[right - 1])
			right--;
		if (right == n - 1)
			return false;

		return left == right;
	}	
}
