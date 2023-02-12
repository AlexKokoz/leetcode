package org.leetcode.contests.biweekly.bw0097;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int[] separateDigits(int[] nums) {
		int n = nums.length;
		int[] ans = new int[6 * n + 1];
		int p = 0;
		for (int num : nums) {
			for (char c : (num + "").toCharArray()) {
				ans[p++] = c - '0';
			}
		}
		return Arrays.copyOf(ans, p);
	}
}
