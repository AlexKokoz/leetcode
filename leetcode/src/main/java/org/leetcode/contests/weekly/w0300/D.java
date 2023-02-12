package org.leetcode.contests.weekly.w0300;

import java.util.PriorityQueue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int countPaths(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]);
		});
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				pq.add(new int[] { i, j });
			}
		}
		int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		long[][] dp = new long[n][m];
		long mod = 1000000007;
		long ans = 0;
		while (!pq.isEmpty()) {
			int node[] = pq.poll(), r = node[0], c = node[1];
			dp[r][c] = 1;
			for (int[] d : d4) {
				int nr = r + d[0], nc = c + d[1];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] >= grid[r][c])
					continue;
				dp[r][c] += dp[nr][nc];
				dp[r][c] %= mod;
			}
			ans += dp[r][c];
			ans %= mod;
		}
		return (int) ans;

	}
}
