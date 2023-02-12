package org.leetcode.contests.biweekly.bw0041;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001685_SumOfAbsoluteDifferencesInASortedArray {
	public int[] getSumAbsoluteDifferences(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		int[] pre = new int[n];
		for (int i = 1; i < n; i++) {
			int diff = nums[i] - nums[i - 1];
			pre[i] = pre[i - 1] + diff * i;
		}
		int[] suf = new int[n];
		for (int i = n - 2; i >= 0; i--) {
			int diff = nums[i + 1] - nums[i];
			suf[i] = suf[i + 1] + diff * (n - 1 - i);
		}
		for (int i = 0; i < n; i++) {
			ans[i] = pre[i] + suf[i];
		}
		return ans;
	}
}
