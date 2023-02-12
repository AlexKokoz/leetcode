package org.leetcode.contests.biweekly.bw0070;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int minimumCost(int[] cost) {
		int max = Integer.MIN_VALUE;
		for (int x : cost)
			max = Math.max(max, x);
		int[] count = new int[max + 1];
		for (int x : cost)
			count[x]++;
		int ans = 0;
		int itemCounter = 0;
		for (int i = max; i >= 0; i--) {
			for (int j = 0; j < count[i]; j++) {
				if (itemCounter < 2) {
					ans += i;
					itemCounter++;
				} else {
					itemCounter = 0;
				}

			}
		}
		return ans;
	}
}
