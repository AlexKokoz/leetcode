package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000096_UniqueBSTs {

	public int numTrees(int n) {
		int dp[] = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int range = 2; range <= n; range++) {
			for (int root = 1; root <= range; root++) {
				dp[range] += dp[root - 1] * dp[range - root];
			}
		}
		return dp[n];
	}
}
