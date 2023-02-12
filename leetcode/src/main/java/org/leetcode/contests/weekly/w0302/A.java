package org.leetcode.contests.weekly.w0302;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int[] numberOfPairs(int[] nums) {
		int[] ans = { 0, 0 };
		int[] count = new int[101];
		for (int num : nums) {
			if (count[num] > 0) {
				count[num]--;
				ans[0]++;
				ans[1]--;
			} else {
				count[num]++;
				ans[1]++;
			}
		}
		return ans;
	}
}
