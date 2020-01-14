package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000935_KnightDialer {
	public int knightDialer(int N) {
		int mod = 1000000007;
		int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 }; // row transitions
		int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 }; // column transitions
		int[][] dp = new int[4][3];
		
		/*
		 * Initialize number pads only; counts as first hop.
		 */
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 3; c++) {
				if (r == 3 && (c == 0 || c == 2))
					continue;
				dp[r][c] = 1;
			}
		}

		/*
		 * Simulate remaining N - 1 hops. 
		 */
		for (int i = 1; i < N; i++) {
			int[][] ndp = new int[4][3];
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 3; c++) {
					if (r == 3 && (c == 0 || c == 2))
						continue;
					for (int j = 0; j < dr.length; j++) {
						int nr = r + dr[j]; // destination row
						int nc = c + dc[j]; // destination column
						if (nr >= 0 && nc >= 0 && nr < 4 && nc < 3) {
							ndp[nr][nc] = (ndp[nr][nc] + dp[r][c]) % mod;
						}
					}
				}
			}
			dp = ndp;
		}
		
		/*
		 * Answer will be the sum of all the number pads.
		 */
		int ans = 0;
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 3; c++) {
				if (r == 3 && (c == 0 || c == 2))
					continue;
				ans = (ans + dp[r][c]) % mod;
			}
		} 
		
		return ans;
	}
}
