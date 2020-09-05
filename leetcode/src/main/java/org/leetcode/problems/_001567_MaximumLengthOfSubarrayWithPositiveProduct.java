package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001567_MaximumLengthOfSubarrayWithPositiveProduct {
	public int getMaxLen(int[] nums) {
		int n = nums.length;
		int max = 0;
		int neg = 0;
		int count = 0;
		int lastNeg = -1;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				count = 0;
				neg = 0;
				lastNeg = -1;
			} else {
				if (nums[i] < 0) {
					neg++;
					if (lastNeg < 0)
						lastNeg = i;
				}
				count++;
				if ((neg & 1) == 0)
					max = Math.max(max, count);
				else {
					max = Math.max(max, i - lastNeg);
				}
			}
		}
		return max;
	}
}
