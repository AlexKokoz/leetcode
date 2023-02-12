package org.leetcode.contests.weekly.w0286;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minDeletion(int[] nums) {
		int n = nums.length;
		int ans = 0;
		int p = 0;
		for (int i = 0; i < n; i++) {
			if (p % 2 == 0) {
				nums[p++] = nums[i];
			} else {
				if (nums[p - 1] != nums[i]) {
					nums[p++] = nums[i];
				} else {
					ans++;
				}
			}
		}
		if (p % 2 == 1)
			ans++;
		return ans;

	}
}
