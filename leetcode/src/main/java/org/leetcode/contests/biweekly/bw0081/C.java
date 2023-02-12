package org.leetcode.contests.biweekly.bw0081;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maximumXOR(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			for (int b = 0; b < 32; b++) {
				if (num << ~b < 0) {
					ans |= 1 << b;
				}
			}
		}
		return ans;
	}
}
