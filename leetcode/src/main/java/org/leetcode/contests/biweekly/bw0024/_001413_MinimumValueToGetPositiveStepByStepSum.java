package org.leetcode.contests.biweekly.bw0024;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001413_MinimumValueToGetPositiveStepByStepSum {
	public int minStartValue(int[] nums) {
		int ans = 0;
		int sum = 0;
		for (int num : nums) {
			sum += num;
			if (sum <= 0) {
				ans += 1 - sum;
				sum = 1;
			}
		}
		return ans == 0 ? 1 : ans;
	}
}
