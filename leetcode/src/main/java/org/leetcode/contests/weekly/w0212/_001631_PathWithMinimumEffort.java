package org.leetcode.contests.weekly.w0212;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001631_PathWithMinimumEffort {
	int ans;
	int[][] effort;
	int[][] h;
	static int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int minimumEffortPath(int[][] h) {
		ans = Integer.MAX_VALUE;
		effort = new int[h.length][h[0].length];
		for (int[] row : effort)
			Arrays.fill(row, Integer.MAX_VALUE);
		effort[0][0] = 0;
		this.h = h;
		dfs(-1, -1, 0, 0, 0);
		return ans;
	}

	void dfs(int pr, int pc, int r, int c, int cur) {
		if (r == h.length - 1 && c == h[0].length - 1) {
			ans = Math.min(ans, effort[h.length - 1][h[0].length - 1]);
			return;
		}
		for (int[] d : d4) {
			int nr = r + d[0];
			int nc = c + d[1];
			if (nr == pr && nc == pc || nr < 0 || nc < 0 || nr >= h.length || nc >= h[0].length)
				continue;
			int cand = Math.max(cur, Math.abs(h[r][c] - h[nr][nc]));
			if (cand >= effort[nr][nc] || cand >= ans)
				continue;
			effort[nr][nc] = cand;
			dfs(r, c, nr, nc, cand);
		}
	}
}
