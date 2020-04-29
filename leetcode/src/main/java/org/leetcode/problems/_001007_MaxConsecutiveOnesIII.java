package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001007_MaxConsecutiveOnesIII {
	public int longestOnes(int[] nums, int k) {
		int max = 0;
		int count = 0;
		int left = 0;
		int right = 0;
		int n = nums.length;
		while (right < n) {
			if (nums[right] == 1) {
				count++;
				right++;
			} else {
				if (k > 0) {
					count++;
					k--;
					right++;
				} else {
					if (nums[left] == 0)
						k++;
					count--;
					left++;
				}
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
