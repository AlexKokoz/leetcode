package org.leetcode.contests.biweekly.bw0048;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int getMaximumConsecutive(int[] coins) {
		int ans = 0;
		Arrays.sort(coins);
		for (int c : coins) {
			if (c <= ans + 1) {
				ans += c;
			}
		}
		return ans + 1;
	}
}
