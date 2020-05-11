package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000080_RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int len = 0;
		int i = 0;
		while (i < n) {
			if (i < n - 1 && nums[i] == nums[i + 1]) {
				nums[len++] = nums[i++];
				nums[len++] = nums[i++];
				while (i < n && nums[i] == nums[i - 1])
					i++;
			} else {
				nums[len++] = nums[i++];
			}
		}
		return len;
	}
}
