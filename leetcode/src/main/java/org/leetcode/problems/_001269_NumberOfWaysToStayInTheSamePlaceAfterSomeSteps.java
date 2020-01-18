package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001269_NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

	public int numWays(int steps, int arrLen) {
		int mod = 1000000007;

		/*
		 * The maximum distance that can be covered from index 0 to the right(and still
		 * have leftover steps to return to 0) is nsteps / 2, which with index 0, denote
		 * an array of size nsteps / 2 + 1. Since arrLen can be smaller, we take the
		 * minimum of the 2 values.
		 */
		int lim = Math.min(steps / 2 + 1, arrLen);

		int[] dp = new int[lim];
		dp[0] = 1;
		for (int k = 0; k < steps; k++) {
			int[] ndp = new int[lim];
			for (int i = 0; i < lim; i++) {
				if (dp[i] == 0)
					continue;
				if (i - 1 >= 0)
					ndp[i - 1] = (ndp[i - 1] + dp[i]) % mod;
				if (i + 1 < lim)
					ndp[i + 1] = (ndp[i + 1] + dp[i]) % mod;
				ndp[i] = (ndp[i] + dp[i]) % mod;
			}
			dp = ndp;
		}
		return dp[0];
	}
}
