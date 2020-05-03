package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001437_CheckIfAll1sAreAtLeastLengthKPlacesAway {
	public boolean kLengthApart(int[] nums, int k) {
		int n = nums.length;
		int i = 0;
		while (i < n && nums[i] != 1)
			i++;
		if (i == n)
			return true;
		i++;
		int count = 0;
		while (i < n) {
			while (i < n && nums[i] != 1) {
				count++;
				i++;
			}
			if (i == n)
				return true;
			if (count < k)
				return false;
			i++;
			count = 0;
		}
		return true;
	}
}
