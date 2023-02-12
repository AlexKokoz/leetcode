package org.leetcode.contests.weekly.w0285;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int countHillValley(int[] nums) {
		int ans = 0;
		int n = nums.length;
		for (int l = 0; l < n;) {
			int r = l;
			while (r < n && nums[r] == nums[l]) {
				r++;
			}
			if (0 < l && r < n) {
				if (nums[l - 1] < nums[l] && nums[l] > nums[r])
					ans++;
				if (nums[l - 1] > nums[l] && nums[l] < nums[r])
					ans++;
			}
			l = r;
		}
		return ans;
	}
}
