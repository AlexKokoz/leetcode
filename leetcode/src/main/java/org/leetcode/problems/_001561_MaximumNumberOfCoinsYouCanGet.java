package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001561_MaximumNumberOfCoinsYouCanGet {
	public int maxCoins(int[] piles) {
		int n = piles.length;
		int ans = 0;
		Arrays.sort(piles);
		for (int i = 0, hi = n - 2; i < n / 3; i++, hi -= 2) {
			ans += piles[hi];
		}
		return ans;
	}
}
