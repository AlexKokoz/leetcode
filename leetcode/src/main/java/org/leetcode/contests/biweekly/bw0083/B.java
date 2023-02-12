package org.leetcode.contests.biweekly.bw0083;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public long zeroFilledSubarray(int[] nums) {
		long ans = 0;
		int n = nums.length;
		for (int l = 0; l < n;) {
			if (nums[l] != 0) {
				l++;
				continue;
			}
			int r = l;
			while (r < n && nums[r] == nums[l])
				r++;
			int len = r - l;
			ans += (long) len * (len + 1) / 2;
			l = r;
		}
		return ans;
	}
}
