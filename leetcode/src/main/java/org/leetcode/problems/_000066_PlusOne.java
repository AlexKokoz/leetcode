package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000066_PlusOne {
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int[] ans = new int[n + 1];
		int carry = 1;
		for (int i = n - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			ans[i + 1] = sum % 10;
			carry = sum / 10;
		}
		ans[0] = carry;
		return (ans[0] == 0 ? Arrays.copyOfRange(ans, 1, ans.length) : ans);
	}
}
