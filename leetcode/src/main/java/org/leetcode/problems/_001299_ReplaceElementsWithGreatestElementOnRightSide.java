package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001299_ReplaceElementsWithGreatestElementOnRightSide {
	public int[] replaceElements(int[] nums) {
		int n = nums.length;
		int rightMax = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			int temp = nums[i];
			nums[i] = rightMax;
			if (temp > rightMax)
				rightMax = temp;
		}
		nums[n - 1] = -1;
		return nums;
	}
}
