package org.leetcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000638_ShoppingOffers {
	int minCost;
	List<Integer> price;
	List<List<Integer>> special;
	List<Integer> needs;
	int n;

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		this.n = needs.size();

		this.price = price;
		this.special = special;
		this.needs = needs;

		for (int i = 0; i < n; i++) {
			minCost += needs.get(i) * price.get(i);
		}
		int[] currently = new int[n];
		dfs(currently, 0);

		return minCost;
	}

	void dfs(int[] currently, int cost) {
		if (cost >= minCost)
			return;
		boolean ok = true;
		for (int i = 0; i < n; i++) {
			if (currently[i] > needs.get(i)) {
				return;
			}
			if (currently[i] < needs.get(i)) {
				ok = false;
			}
		}
		if (ok) {
			minCost = Math.min(minCost, cost);
		}

		considerManualCost(currently, cost);

		for (List<Integer> offer : special) {
			int[] ncurrently = Arrays.copyOf(currently, n);
			for (int i = 0; i < n; i++) {
				ncurrently[i] += offer.get(i);
			}
			dfs(ncurrently, cost + offer.get(offer.size() - 1));
		}
	}

	void considerManualCost(int[] currently, int cost) {
		for (int i = 0; i < n; i++) {
			cost += (needs.get(i) - currently[i]) * price.get(i);
		}
		minCost = Math.min(minCost, cost);
	}
}
