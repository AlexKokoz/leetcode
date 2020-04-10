package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000417_PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] m) {
		final List<List<Integer>> ans = new LinkedList<>();
		final int R = m.length;
		if (R == 0)
			return ans;
		final int C = m[0].length;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				final boolean[][] marked = new boolean[R][C];
				final boolean[] flag = new boolean[2];

				dfs(r, c, marked, m, flag);
				if (flag[0] && flag[1]) {
					final List<Integer> point = new LinkedList<>();
					point.add(r);
					point.add(c);
					ans.add(point);
				}

			}
		}
		return ans;
	}

	static void dfs(int r, int c, boolean[][] marked, int[][] m, boolean[] flag) {
		marked[r][c] = true;
		if (r == 0 || c == 0)
			flag[0] = true;
		if (r == m.length - 1 || c == m[0].length - 1)
			flag[1] = true;
		if (flag[0] && flag[1])
			return;
		if (r > 0 && !marked[r - 1][c] & m[r][c] >= m[r - 1][c]) {
			dfs(r - 1, c, marked, m, flag);
		}
		if (r < m.length - 1 && !marked[r + 1][c] & m[r][c] >= m[r + 1][c]) {
			dfs(r + 1, c, marked, m, flag);
		}
		if (c > 0 && !marked[r][c - 1] & m[r][c] >= m[r][c - 1]) {
			dfs(r, c - 1, marked, m, flag);
		}
		if (c < m[0].length - 1 && !marked[r][c + 1] & m[r][c] >= m[r][c + 1]) {
			dfs(r, c + 1, marked, m, flag);
		}

	}
}
