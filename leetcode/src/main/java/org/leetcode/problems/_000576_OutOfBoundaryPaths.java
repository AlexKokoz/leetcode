package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000576_OutOfBoundaryPaths {
	public int findPaths(int nr, int nc, int K, int i, int j) {
		int[][] dp = new int[nr][nc];
		int count = 0;
		int mod = 1000000007;
		int[] dr = { -1, 0, 1, 0 }; // top, right, bottom, left
		int[] dc = { 0, 1, 0, -1 }; // top, right, bottom, left
		dp[i][j] = 1;
		for (int k = 0; k < K; k++) {
			int[][] ndp = new int[nr][nc];
			for (int r = 0; r < nr; r++) {
				for (int c = 0; c < nc; c++) {
					if (dp[r][c] == 0)
						continue;
					for (int z = 0; z < dr.length; z++) {
						int rr = r + dr[z];
						int cc = c + dc[z];
						if (rr < 0 || cc < 0 || rr >= nr || cc >= nc) {
							count = (count + dp[r][c]) % mod;
						} else {
							ndp[rr][cc] = (ndp[rr][cc] + dp[r][c]) % mod;
						}
					}
				}
			}
			dp = ndp;
		}
		return count;
	}
}
