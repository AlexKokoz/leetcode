package org.leetcode.contests.weekly.w0236;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001822_SignOfTheProductOfAnArray {
	public int arraySign(int[] nums) {
		int ans = 1;
		for (int num : nums) {
			if (num == 0)
				return 0;
			ans *= Math.signum(num);
		}
		return ans;
	}
}
