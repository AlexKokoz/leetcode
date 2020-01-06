package org.leetcode.contests.weekly.w0168;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001295_FindNumbersWithEvenNumbersOfDigits {
	public int findNumbers(int[] a) {
		int ans = 0;
		for (int x : a) {
			final String s = Integer.toString(x);
			if (s.length() % 2 == 0)
				ans++;
		}
		return ans;
	}
}
