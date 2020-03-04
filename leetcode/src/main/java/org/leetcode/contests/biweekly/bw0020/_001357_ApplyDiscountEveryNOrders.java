package org.leetcode.contests.biweekly.bw0020;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001357_ApplyDiscountEveryNOrders {
	class Cashier {
		private final int n;
		private final int discount;
		private final int[] prices;
		private int counter;
		private final Map<Integer, Integer> prod2pos;

		public Cashier(int n, int discount, int[] products, int[] prices) {
			this.n = n;
			this.discount = discount;
			this.prices = prices;
			this.counter = 0;
			this.prod2pos = new HashMap<>();
			for (int i = 0; i < products.length; i++)
				this.prod2pos.put(products[i], i);
		}

		public double getBill(int[] product, int[] amount) {
			this.counter++;
			double bill = 0;
			if (this.counter == this.n) {
				for (int i = 0; i < product.length; i++) {
					int id = product[i];
					int pos = this.prod2pos.get(id);
					bill += prices[pos] * amount[i];
				}
				bill = ((double) bill - bill * discount / 100);
				this.counter = 0;
			} else {
				for (int i = 0; i < product.length; i++) {
					int id = product[i];
					int pos = this.prod2pos.get(id);
					bill += prices[pos] * amount[i];
				}
			}
			return bill;
		}
	}
}
