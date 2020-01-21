package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001130_MinimumCostTreeFromLeafValues {

	public int mctFromLeafValues(int[] arr) {

		int n = arr.length;
		int[][] dp = new int[n][n];
		int[][] max = new int[n][n];

		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			max[i][i] = arr[i]; 
			dp[i][i] = 0;
		}

		for (int len = 1; len < n; len++) {     // for each interval gap length [1..n - 1]
			for (int L = 0; L < n - len; L++) { // for each valid left position
				int R = L + len;                // calculate its 'mirror' right position
				for (int i = L; i < R; i++) {   // check all partitions of the current interval
					int cost = dp[L][i] + dp[i + 1][R] + max[L][i] * max[i + 1][R];
					if (dp[L][R] > cost) {
						dp[L][R] = cost;
						max[L][R] = Math.max(max[L][i], max[i + 1][R]); 
					}
				}
			}
		}
		
		return dp[0][n - 1];
	}

}
