package org.leetcode.contests.biweekly.bw0028;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001475_FinalPricesWitSpecialDiscountInAShop {
	public int[] finalPrices(int[] prices) {
		int n = prices.length;
		int[] ans = Arrays.copyOf(prices, n);
		for (int i = 0; i < n - 1; i++) {
			int j;
			for (j = i + 1; j < n && prices[i] > prices[j]; j++)
				;
			if (j == n)
				continue;
			ans[i] -= ans[j];
		}
		return ans;
	}
}
