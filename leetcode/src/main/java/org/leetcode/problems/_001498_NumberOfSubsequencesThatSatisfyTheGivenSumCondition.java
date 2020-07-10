package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
	public int numSubseq(int[] nums, int target) {
		int n = nums.length;
		long mod = 1000000007;
		long[] p = new long[n];
		p[0] = 1;
		for (int i = 1; i < p.length; i++)
			p[i] = (p[i - 1] * 2 ) % mod;
		Arrays.sort(nums);
		long ans = 0;
		for (int lo = 0, hi = n - 1; lo < n; lo++) {
			while(lo < hi && nums[lo] + nums[hi] > target) 
				hi--;
			if (nums[lo] + nums[hi] > target) break;
			ans = (ans + p[hi - lo]) % mod;
		}
		return (int) ans;
	}
}
