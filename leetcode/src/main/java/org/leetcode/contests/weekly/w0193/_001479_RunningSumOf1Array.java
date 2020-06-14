package org.leetcode.contests.weekly.w0193;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001479_RunningSumOf1Array {
	public int[] runningSum(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		ans[0] = nums[0];
		for (int i = 1; i < n; i++)
			ans[i] = ans[i - 1] + nums[i];
		return ans;
	}
}
