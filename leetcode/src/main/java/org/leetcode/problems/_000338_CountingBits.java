package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000338_CountingBits {
	public int[] countBits(int num) {
		final int[] ans = new int[num + 1];
		if (num == 0)
			return ans;
		ans[1] = 0;
		int k = 0;
		for (int i = 2; i <= num; i++) {
			if ((i & (i - 1)) == 0) { // power of 2
				k = i;
				ans[i] = 1;
			} else {
				ans[i] = 1 + ans[i - k];
			}
		}
		return ans;
	}
}
