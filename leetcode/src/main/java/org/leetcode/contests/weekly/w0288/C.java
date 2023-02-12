package org.leetcode.contests.weekly.w0288;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maximumProduct(int[] nums, int k) {
		long mod = 1000000007;
		long ans = 1;
		int n = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < n && k > 0; i++) {
			while ((i == n - 1 || nums[i] < nums[i + 1]) && k > 0) {
				int j = i;
				while (k > 0 && j >= 0) {
					nums[j]++;
					k--;
					j--;
				}
			}
		}
		for (int num : nums) {
			ans *= num;
			ans %= mod;
		}
		return (int) ans;
	}
}
