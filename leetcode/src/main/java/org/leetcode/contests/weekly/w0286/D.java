package org.leetcode.contests.weekly.w0286;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public int maxValueOfCoins(List<List<Integer>> piles, int k) {
		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		for (List<Integer> pile : piles) {
			int len = pile.size();
			int[] ndp = Arrays.copyOf(dp, dp.length);
			for (int i = 0, sum = 0; i < len && i < k; i++) {
				sum += pile.get(i);
				for (int j = 0; j + i + 1 <= k; j++) {
					if (dp[j] == Integer.MIN_VALUE)
						continue;
					ndp[j + i + 1] = Math.max(ndp[j + i + 1], dp[j] + sum);
				}
			}

			dp = ndp;
		}
		return dp[k];
	}
}
