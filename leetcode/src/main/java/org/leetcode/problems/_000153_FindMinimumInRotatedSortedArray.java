package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int n = nums.length;
		if (nums[0] <= nums[n - 1])
			return nums[0];
		int lo = 0;
		int hi = n - 1;
		while (lo <= hi) {
			int mi = lo + (hi - lo >> 1);
			if (nums[mi] >= nums[0])
				lo = mi + 1;
			else
				hi = mi - 1;
		}
		return nums[lo];
	}
}
