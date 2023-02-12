package org.leetcode.contests.biweekly.bw0076;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int findClosestNumber(int[] nums) {
		int ans = Integer.MAX_VALUE;
		for (int num : nums) {
			if (Math.abs(num) < Math.abs(ans) || (Math.abs(num) == Math.abs(ans) && num > ans)) {
				ans = num;
			}
		}
		return ans;
	}
}
