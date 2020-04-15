package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000628_MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] nums) {
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num >= firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = num;
			} else if (num >= secondMax) {
				thirdMax = secondMax;
				secondMax = num;
			} else if (num > thirdMax) {
				thirdMax = num;
			}

			if (num <= firstMin) {
				secondMin = firstMin;
				firstMin = num;
			} else if (num < secondMin) {
				secondMin = num;
			}
		}
		return Math.max(firstMax * secondMax * thirdMax, firstMax * firstMin * secondMin);
	}
}
