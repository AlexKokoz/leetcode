package org.leetcode.problems;

import java.util.Arrays;

/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001363_LargestMultipleOfThree {
	/*
	 * Intuitions:
	 * 
	 * - A number is divisible by 3 if the sum of its digits is divisible by 3.
	 * 
	 * - We can make any number divisible by 3 with at most 2 digits removals.
	 * 
	 */
	public String largestMultipleOfThree(int[] digits) {
		int n = digits.length;
		Arrays.sort(digits);
		int sum = 0;
		for (int x : digits)
			sum += x;

		// already divisible by 3
		if (sum % 3 == 0)
			return buildMultiple(digits);

		// check if 1 digit removal will yield a multiple of 3; if yes, this will result
		// in a larger number than any 2 digit removal; mark removed digit with -1.
		for (int i = 0; i < n; i++) {
			if ((sum - digits[i]) % 3 == 0 && n > 1) {
				if (sum - digits[i] == 0)
					return "0";
				digits[i] = -1;
				return buildMultiple(digits);
			}
		}

		// check if 2 digit removal will yield a multiple of 3; mark removed digit with
		// -1.
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((sum - digits[i] - digits[j]) % 3 == 0 && n > 2) {
					if (sum - digits[i] - digits[j] == 0)
						return "0";
					digits[i] = digits[j] = -1;
					return buildMultiple(digits);
				}
			}
		}

		// not feasible to obtain a multiple of 3.
		return "";
	}

	String buildMultiple(int[] digits) {
		StringBuilder sb = new StringBuilder();
		int i = digits.length - 1;
		while (i >= 0 && (digits[i] == 0 || digits[i] == -1))
			i--;
		if (i == -1) // case where all valid numbers are 0.
			return "0";
		for (; i >= 0; i--) {
			if (digits[i] == -1)
				continue;
			sb.append(digits[i]);
		}
		return sb.toString();
	}
}
