package org.leetcode.contests.biweekly.bw0078;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int waysToSplitArray(int[] nums) {
		long total = 0;
		for (int num : nums)
			total += num;
		int n = nums.length;
		int ans = 0;
		long pref = 0;
		for (int i = 0; i < n - 1; i++) {
			pref += nums[i];
			total -= nums[i];
			if (pref >= total)
				ans++;
		}
		return ans;
	}
}
