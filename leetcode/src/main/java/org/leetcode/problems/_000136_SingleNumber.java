package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000136_SingleNumber {
	public int singleNumber(int[] nums) {
		int mask = 0;
		for (int num : nums)
			mask ^= num;
		return mask;
	}
}
