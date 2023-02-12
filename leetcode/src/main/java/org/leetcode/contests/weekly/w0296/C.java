package org.leetcode.contests.weekly.w0296;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int[] arrayChange(int[] nums, int[][] ops) {
		int n = nums.length, m = ops.length;
		int max = Integer.MIN_VALUE;
		for (int num : nums)
			max = Math.max(max, num);
		for (int[] op : ops) {
			max = Math.max(max, op[0]);
			max = Math.max(max, op[1]);
		}
		int[] val = new int[max + 1];
		Arrays.fill(val, -1);
		for (int j = m - 1; j >= 0; j--) {
			if (val[ops[j][1]] != -1) {
				val[ops[j][0]] = val[ops[j][1]];
			} else {
				val[ops[j][0]] = ops[j][1];
			}
		}
		for (int i = 0; i < n; i++) {
			if (val[nums[i]] != -1) {
				nums[i] = val[nums[i]];
			}
		}
		return nums;
	}
}
