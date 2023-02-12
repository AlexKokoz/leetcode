package org.leetcode.contests.weekly.w0302;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int maximumSum(int[] nums) {
		int[][] maxes = new int[101][2];
		int ans = -1;
		for (int num : nums) {
			int x = num;
			int sum = 0;
			while (x > 0) {
				sum += x % 10;
				x /= 10;
			}
			if (num >= maxes[sum][0]) {
				maxes[sum][1] = maxes[sum][0];
				maxes[sum][0] = num;
			} else if (num > maxes[sum][1]) {
				maxes[sum][1] = num;
			}
			if (maxes[sum][0] > 0 && maxes[sum][1] > 0) {
				ans = Math.max(ans, maxes[sum][0] + maxes[sum][1]);
			}
		}
		return ans;
	}
}
