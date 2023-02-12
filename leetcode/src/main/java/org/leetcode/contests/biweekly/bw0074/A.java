package org.leetcode.contests.biweekly.bw0074;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public boolean divideArray(int[] nums) {
		int[] count = new int[501];
		for (int num : nums)
			count[num]++;
		for (int x : count) {
			if (x % 2 == 1)
				return false;
		}
		return true;
	}
}
