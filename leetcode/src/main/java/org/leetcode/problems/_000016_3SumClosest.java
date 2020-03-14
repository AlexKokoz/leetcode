package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000016_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		Integer ans = null;
		Integer ansDiff = null;

		Arrays.sort(nums);
		for (int i = 0; i <= n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int lo = i + 1;
			int hi = n - 1;
			int target2Sum = target - nums[i];
			while (lo < hi) {
				int cur2Sum = nums[lo] + nums[hi];
				int diff = Math.abs(cur2Sum - target2Sum);
				if (ansDiff == null || ansDiff > diff) {
					ansDiff = diff;
					ans = nums[i] + cur2Sum;
				}
				if (cur2Sum == target2Sum) {
					return ans;
				} else if (cur2Sum < target2Sum) {
					lo++;
				} else {
					hi--;
				}
			}
		}
		return ans;
	}
}
