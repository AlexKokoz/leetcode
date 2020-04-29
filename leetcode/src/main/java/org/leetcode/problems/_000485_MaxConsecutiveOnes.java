package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000485_MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int count = 0;
		for (int num : nums) {
			count = num == 1 ? count + 1 : 0;
			max = Math.max(max, count);
		}
		return max;
	}
}