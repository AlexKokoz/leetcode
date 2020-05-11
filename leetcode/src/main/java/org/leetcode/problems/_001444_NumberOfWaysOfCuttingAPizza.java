package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001444_NumberOfWaysOfCuttingAPizza {
	public int ways(String[] pizza, int k) {
		long mod = 1000000007;
		int[][] cum = buildCumRev(pizza);
		int n = pizza.length;
		int m = pizza[0].length();
		Long[][][] dp = new Long[n][m][k];
		return (int) dfs(0, 0, n, m, dp, cum, k - 1, mod);
	}

	long dfs(int r, int c, int n, int m, Long[][][] dp, int[][] cum, int k, long mod) {
		if (cum[r][c] == 0) { // no remaining apples for the current piece; invalid
			return 0;
		} else if (k == 0) { // 1 way to cut the pizza with 0 cuts
			return 1;
		} else if (dp[r][c][k] != null) { // use already computed result
			return dp[r][c][k];
		}

		long ways = 0;

		// for all currently possible horizontal cuts
		for (int i = r + 1; i < n; i++) { //
			if (cum[r][c] - cum[i][c] == 0)
				continue; // dont consider pieces without apples
			ways += dfs(i, c, n, m, dp, cum, k - 1, mod);
			if (ways >= mod) {
				ways -= mod;
			}
		}

		// for all currently possible vertical cuts
		for (int i = c + 1; i < m; i++) {
			if (cum[r][c] - cum[r][i] == 0)
				continue; // dont consider pieces without apples
			ways += dfs(r, i, n, m, dp, cum, k - 1, mod);
			if (ways >= mod) {
				ways -= mod;
			}
		}

		dp[r][c][k] = ways;
		return ways;
	}

	int[][] buildCumRev(String[] mat) {
		int n = mat.length;
		int m = (n == 0) ? 0 : mat[0].length();
		int[][] ret = new int[n + 1][m + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				ret[i][j] = (mat[i].charAt(j) == 'A' ? 1 : 0) + ret[i + 1][j] + ret[i][j + 1]
						- ret[i + 1][j + 1];
			}
		}
		return ret;
	}
}
