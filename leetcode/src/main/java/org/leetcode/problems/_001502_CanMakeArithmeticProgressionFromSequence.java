package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001502_CanMakeArithmeticProgressionFromSequence {
	public boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		int diff = arr[1] - arr[0];
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] != diff) return false;
		}
		return true;

	}
}
