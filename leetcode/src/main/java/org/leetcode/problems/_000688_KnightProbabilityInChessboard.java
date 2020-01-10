package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000688_KnightProbabilityInChessboard {
	public double knightProbability(int N, int K, int r, int c) {
		double[][] dp = new double[N][N];
		int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 }; // row transitions staring from top-right position
		int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 }; // column transitions staring from top-right position
		dp[r][c] = 1;
		for (int k = 0; k < K; k++) {
			double[][] ndp = new double[N][N];
			for (int ir = 0; ir < N; ir++) {
				for (int ic = 0; ic < N; ic++) {
					if (dp[ir][ic] > 0) {
						for (int j = 0; j < dr.length; j++) {
							int nr = ir + dr[j];
							int nc = ic + dc[j];
							if (nr >= 0 && nc >= 0 && nr < N && nc < N)
								ndp[nr][nc] += dp[ir][ic] / 8.0;
						}
					}
				}
			}
			dp = ndp;
		}

		double ans = 0;
		for (double[] row : dp)
			for (double p : row)
				ans += p;
		return ans;
	}

}
