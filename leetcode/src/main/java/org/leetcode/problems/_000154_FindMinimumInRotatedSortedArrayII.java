package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000154_FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
		int n = nums.length;
		int lo = 0;
		int hi = n - 1;
		while (lo < hi && nums[lo] == nums[hi]) {
			hi--;
		}
		if (lo == hi || nums[lo] < nums[hi])
			return nums[lo];
		int first = lo;
		while (lo <= hi) {
			int mi = lo + (hi - lo >> 1);
			if (nums[mi] >= nums[first]) lo = mi + 1;
			else                         hi = mi - 1;
		}
		return nums[lo];
	}
}
