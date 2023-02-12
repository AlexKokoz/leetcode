package org.leetcode.contests.biweekly.bw0075;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int triangularSum(int[] nums) {
		while (nums.length > 1) {
			int[] temp = new int[nums.length - 1];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = (nums[i] + nums[i + 1]) % 10;
			}
			nums = temp;
		}
		return nums[0];
	}
}
