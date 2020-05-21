package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000081_SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		return search(0, nums.length - 1, nums, target);
	}

	static boolean search(int lo, int hi, int[] nums, int target) {
		while (lo <= hi) {
			int mi = lo + (hi - lo >>> 1);
			if (nums[mi] != target && lo < hi && nums[lo] == nums[hi]) {
				while (++lo < hi && nums[lo - 1] == nums[lo])
					;
				mi = lo + (hi - lo >> 1);
			}
			if (target < nums[mi]) {
				if (nums[lo] <= nums[mi] && target < nums[lo]) {
					lo = mi + 1;
				} else {
					hi = mi - 1;
				}
			} else if (nums[mi] < target) {
				if (nums[mi] <= nums[hi] && nums[hi] < target) {
					hi = mi - 1;
				} else {
					lo = mi + 1;
				}
			} else {
				return true;
			}
		}
		return false;
	}
}
