package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001518_WaterBottles {
	public int numWaterBottles(int numBottles, int numExchange) {
		int ans = 0;
		int leftovers = 0;
		while (numBottles > 0) {
			ans += numBottles;
			int temp = numBottles;
			numBottles = (numBottles + leftovers) / numExchange;
			leftovers = (temp + leftovers) % numExchange;
		}
		return ans;
	}
}
