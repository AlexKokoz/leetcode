package org.leetcode.contests.weekly.w0296;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int partitionArray(int[] nums, int k) {
		int n = nums.length;
		int ans = 0;
		Arrays.sort(nums);
		for (int l = 0; l < n;) {
			int r = l;
			while (r < n && nums[r] - nums[l] <= k) {
				r++;
			}
			ans++;
			l = r;
		}
		return ans;
	}
}
