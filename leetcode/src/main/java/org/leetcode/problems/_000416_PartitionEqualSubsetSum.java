package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000416_PartitionEqualSubsetSum {

	int[] nums;
	int half;

	public boolean canPartition(int[] nums) {
		Arrays.sort(nums);
		this.nums = nums;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if ((sum & 1) == 1 || nums.length == 1)
			return false;
		if (nums[0] == nums[nums.length - 1])
			return true;
		half = sum >> 1;
		return dfs(nums[nums.length - 1], 0, nums.length - 2);
	}

	boolean dfs(int sum1, int sum2, int d) {
		if (d < 0)
			return sum1 == sum2;

		if (sum1 > half || sum2 > half)
			return false;
		return dfs(sum1 + nums[d], sum2, d - 1) || dfs(sum1, sum2 + nums[d], d - 1);
	}

}
