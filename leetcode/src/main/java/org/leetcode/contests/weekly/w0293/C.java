package org.leetcode.contests.weekly.w0293;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int largestCombination(int[] nums) {
		int[] bits = new int[32];
		for (int num : nums) {
			for (int b = 0; b < 32; b++) {
				if (num << ~b < 0) {
					bits[b]++;
				}
			}
		}
		int ans = 0;
		for (int bit : bits) {
			ans = Math.max(ans, bit);
		}
		return ans;
	}
}
