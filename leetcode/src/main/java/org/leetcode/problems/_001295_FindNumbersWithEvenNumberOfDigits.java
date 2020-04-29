package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001295_FindNumbersWithEvenNumberOfDigits {
	public int findNumbers(int[] nums) {
		int evens = 0;
		for (int num : nums)
			if (hasEvenDigits(num))
				evens++;
		return evens;
	}

	boolean hasEvenDigits(int num) {
		int nDigits = 0;
		while (num > 0) {
			nDigits++;
			num /= 10;
		}
		return nDigits % 2 == 0;
	}
}
