package org.leetcode.contests.weekly.w0227;

import java.util.TreeSet;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001755_ClosestSubsequenceSum {
	public int minAbsDifference(int[] nums, int goal) {
		int n = nums.length;
		int h = n / 2;
		int ans = Integer.MAX_VALUE;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < 1 << h; i++) {
			int s = 0;
			for (int k = 0; k < h; k++) {
				if (i << ~k < 0)
					s += nums[k];
			}
			set.add(s);
		}
		for (int i = 0; i < 1 << (n - h); i++) {
			int s = 0;
			for (int k = 0; k < (n - h); k++) {
				if (i << ~k < 0)
					s += nums[h + k];
			}
			Integer ceiling = set.ceiling(goal - s);
			if (ceiling != null)
				ans = Math.min(ans, Math.abs(goal - s - ceiling));
			Integer floor = set.floor(goal - s);
			if (floor != null)
				ans = Math.min(ans, Math.abs(goal - s - floor));
		}
		return ans;

	}
}
