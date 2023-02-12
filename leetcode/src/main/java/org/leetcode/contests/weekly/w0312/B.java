package org.leetcode.contests.weekly.w0312;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int longestSubarray(int[] nums) {
		int n = nums.length;
		int ans = 0;
		int maxAnd = 0;
		for (int i = 0; i < n;) {
			if (nums[i] < maxAnd) {
				i++;
				continue;
			}
			int j = i;
			while (j < n && nums[j] == nums[i]) {
				j++;
			}
			if (nums[i] > maxAnd) {
				maxAnd = nums[i];
				ans = j - i;
			} else {
				ans = Math.max(ans, j - i);
			}
			i = j;
		}
		return ans;
	}
}
