package org.leetcode.contests.weekly.w0291;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minimumCardPickup(int[] cards) {
		int n = cards.length;
		int max = -1;
		for (int card : cards)
			max = Math.max(max, card);
		int[] last = new int[max + 1];
		Arrays.fill(last, -1);
		int ans = n + 1;
		for (int i = 0; i < n; i++) {
			if (last[cards[i]] != -1) {
				ans = Math.min(ans, i - last[cards[i]] + 1);

			}
			last[cards[i]] = i;
		}
		if (ans == n + 1)
			ans = -1;
		return ans;
	}
}
