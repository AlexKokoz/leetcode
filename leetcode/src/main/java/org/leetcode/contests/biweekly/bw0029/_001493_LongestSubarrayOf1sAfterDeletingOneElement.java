package org.leetcode.contests.biweekly.bw0029;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001493_LongestSubarrayOf1sAfterDeletingOneElement {
	public int longestSubarray(int[] nums) {
		int n = nums.length;
		int ans = 0;
		int pre = -1;
		int cur = 0;
		int ctOnes1 = 0;
		int ctOnes2 = 0;
		int ctZeros = 0;
		while (cur < n) {
			while (cur != n - 1 && nums[cur] == nums[cur + 1])
				cur++;
			if (nums[cur] == 1) {
				ctOnes2 = cur - pre;
				if (ctZeros == 1) {
					ans = Math.max(ans, ctOnes1 + ctOnes2);
				} else {
					ans = Math.max(ans, ctOnes2);
				}
				ctOnes1 = ctOnes2;
			} else {
				ctZeros = cur - pre;
			}
			pre = cur;
			cur++;
		}
		if (ans == nums.length)
			return ans - 1;
		return ans;
	}
}
