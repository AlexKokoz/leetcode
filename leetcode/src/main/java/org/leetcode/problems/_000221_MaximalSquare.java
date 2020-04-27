package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000221_MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		if (n == 0)
			return 0;
		int m = matrix[0].length;
		if (m == 0)
			return 0;

		int maxSide = 0;
		int[] dp = new int[m + 1];
		for (int r = 0; r < n; r++) {
			int[] ndp = new int[dp.length];
			for (int c = 0; c < m; c++) {
				if (matrix[r][c] == '0')
					continue;
				ndp[c + 1] = Math.min(dp[c], Math.min(ndp[c], dp[c + 1])) + 1;
				maxSide = Math.max(maxSide, ndp[c + 1]);
			}
			dp = ndp;
		}
		return maxSide * maxSide;
	}
}
