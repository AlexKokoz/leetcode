package org.leetcode.contests.weekly.w0314;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int numberOfPaths(int[][] grid, int k) {
		int n = grid.length;
		int m = grid[0].length;
		long mod = 1000000007;
		long[][][] dp = new long[n][m][k];
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { 0, 0 });
		int[][] lt = { { -1, 0 }, { 0, -1 } };
		int[][] rb = { { 1, 0 }, { 0, 1 } };
		boolean[][] added = new boolean[n][m];
		added[0][0] = true;
		while (!dq.isEmpty()) {
			int node[] = dq.pollFirst(), r = node[0], c = node[1];
			if (r == 0 && c == 0) {
				dp[0][0][grid[0][0] % k] = 1;
			} else {
				for (int[] d : lt) {
					int nr = r + d[0], nc = c + d[1];
					if (0 <= nr && nr < n && 0 <= nc && nc < m) {
						for (int kk = 0; kk < k; kk++) {
							int target = (kk + (grid[r][c] % k)) % k;
							dp[r][c][target] += dp[nr][nc][kk];
							dp[r][c][target] %= mod;
						}
					}
				}
			}
			for (int[] d : rb) {
				int nr = r + d[0], nc = c + d[1];
				if (0 <= nr && nr < n && 0 <= nc && nc < m) {
					if (!added[nr][nc]) {
						dq.add(new int[] { nr, nc });
						added[nr][nc] = true;
					}
				}
			}
		}
		return (int) dp[n - 1][m - 1][0];
	}
}
