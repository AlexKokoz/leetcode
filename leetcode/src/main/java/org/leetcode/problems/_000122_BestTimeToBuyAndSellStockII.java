package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000122_BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int profit = 0;
		for (int i = 0; i < n; i++) {
			int j;
			for (j = i + 1; j < n && prices[j - 1] <= prices[j]; j++);
			profit += prices[j - 1] - prices[i];
			i = j - 1;
		}
		return profit;
	}
}
