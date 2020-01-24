package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000714_BestTimeToBuyAndSellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int noStockInHand = 0;
		int stockInHand = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			noStockInHand = Math.max(noStockInHand, prices[i] + stockInHand - fee);
			stockInHand = Math.max(stockInHand, noStockInHand - prices[i]);
		}
		return Math.max(stockInHand, noStockInHand);
	}
}
