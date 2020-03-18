package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000035_SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int mi = lo + (hi - lo) / 2;
			if (nums[mi] < target)
				lo = mi + 1;
			else if (target < nums[mi])
				hi = mi - 1;
			else
				return mi;
		}
		return nums[lo] < target ? lo + 1 : lo;
	}
}
