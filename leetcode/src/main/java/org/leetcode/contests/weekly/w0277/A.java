package org.leetcode.contests.weekly.w0277;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int countElements(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		int ans = 0;
		for (int num : nums) {
			if (num > min && num < max)
				ans++;
		}
		return ans;
	}
}
