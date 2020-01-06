package org.leetcode.contests.biweekly.bw0016;

import java.util.List;

/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001301_NumberOfPathsWithMaxScore {

	public int[] pathsWithMaxScore(List<String> b) {
		final int[] ans = new int[2];
		final int mod = 1000000007;
		final int R = b.size();
		if (R == 0)
			return ans;
		final int C = b.get(0).length();
		final int[][] dp = new int[R + 2][C + 2];
		final int[][] max = new int[R + 2][C + 2];
		final int[][] ways = new int[R + 2][C + 2];
		ways[R][C] = 1;
		for (int r = 0; r < dp.length; r++) {
			for (int c = 0; c < dp[0].length; c++) {
				if (r == 0 || r == R + 1 || c == 0 || c == C + 1)
					dp[r][c] = Integer.MIN_VALUE;
				else {
					final char ch = b.get(r - 1).charAt(c - 1);
					dp[r][c] = (ch == 'X' ? Integer.MIN_VALUE : ch - '0');
				}
			}
		}
		dp[1][1] = 0;
		dp[R][C] = 0;
		for (int r = R; r > 0; r--) {
			for (int c = C; c > 0; c--) {
				if (r == R && c == C || dp[r][c] == Integer.MIN_VALUE)
					continue;
				max[r][c] = Math.max(dp[r][c + 1], Math.max(dp[r + 1][c + 1], dp[r + 1][c]));

				if (max[r][c] != Integer.MIN_VALUE) {
					if (max[r][c] == dp[r][c + 1])
						ways[r][c] = (ways[r][c] + ways[r][c + 1]) % mod;
					if (max[r][c] == dp[r + 1][c + 1])
						ways[r][c] = (ways[r][c] + ways[r + 1][c + 1]) % mod;
					if (max[r][c] == dp[r + 1][c])
						ways[r][c] = (ways[r][c] + ways[r + 1][c]) % mod;
					dp[r][c] = (max[r][c] + dp[r][c]) % mod;
				} else
					dp[r][c] = max[r][c];
			}
		}
		if (dp[1][1] == Integer.MIN_VALUE)
			return ans;

		ans[0] = dp[1][1];
		ans[1] = ways[1][1];
		return ans;

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
