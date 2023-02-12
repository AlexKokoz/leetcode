package org.leetcode.contests.weekly.w0305;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int arithmeticTriplets(int[] nums, int diff) {
		int ans = 0;
		int f = 0, s = 1, t = 2;
		int n = nums.length;
		while (t < n) {
			while (s < n && nums[s] < nums[f] + diff)
				s++;
			t = Math.max(t, s + 1);
			while (t < n && nums[t] < nums[s] + diff)
				t++;
			if (t < n && nums[t] == nums[s] + diff && nums[s] == nums[f] + diff)
				ans++;
			f++;
		}
		return ans;
	}
}
