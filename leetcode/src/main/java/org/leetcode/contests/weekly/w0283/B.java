package org.leetcode.contests.weekly.w0283;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public long minimalKSum(int[] nums, int k) {
		long ans = 0;
		int n = nums.length;
		Arrays.sort(nums);
		int prev = 0;
		for (int num : nums) {
			if (num - prev - 1 > 0) {
				int take = Math.min(k, num - prev - 1);
				k -= take;
				long max = prev + take;
				ans += sum(prev + 1, max);
				if (k == 0)
					break;
			}
			prev = num;
		}
		if (k > 0) {
			long max = nums[n - 1] + k;
			ans += sum(nums[n - 1] + 1, max);
		}
		return ans;
	}

	long sum(long left, long right) {
		long sum = right * (right + 1) / 2 - left * (left - 1) / 2;
		return sum;
	}
}
