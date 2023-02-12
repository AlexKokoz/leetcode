package org.leetcode.contests.biweekly.bw0077;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minimumAverageDifference(int[] nums) {
		int n = nums.length;
		long[] pre = new long[n + 1];
		for (int i = 0; i < n; i++)
			pre[i + 1] = pre[i] + nums[i];
		long[] suf = new long[n + 1];
		for (int i = n - 1; i >= 0; i--)
			suf[i] = suf[i + 1] + nums[i];
		int ans = -1;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			long cand = Math.abs(pre[i + 1] / (i + 1) - suf[i + 1] / (i == n - 1 ? 1 : (n - i - 1)));
			if (cand < min) {
				min = cand;
				ans = i;
			}
		}
		return ans;
	}
}
