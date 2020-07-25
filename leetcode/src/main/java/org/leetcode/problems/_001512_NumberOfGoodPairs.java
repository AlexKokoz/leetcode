package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001512_NumberOfGoodPairs {
	public int numIdenticalPairs(int[] nums) {
		int ans = 0;
		int[] count = new int[101];
		for (int num : nums)
			count[num]++;
		for (int x : count) {
			ans += (x - 1) * x / 2;
		}
		return ans;
	}
}
