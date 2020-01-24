package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000121_BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int price : prices) {
			if (price < minPrice)
				minPrice = price;
			if (price > minPrice)
				maxProfit = Math.max(maxProfit, price - minPrice);
		}
		return maxProfit;
	}
}
