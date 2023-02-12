package org.leetcode.contests.biweekly.bw0070;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		int n = grid.length, m = grid[0].length;
		int[][] dist = new int[n][m];
		for (int[] row : dist)
			Arrays.fill(row, Integer.MAX_VALUE);
		bfs(start[0], start[1], grid, dist);
		List<int[]> cands = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dist[i][j] != Integer.MAX_VALUE && grid[i][j] >= pricing[0]
						&& grid[i][j] <= pricing[1]) {
					cands.add(new int[] { i, j });
				}
			}
		}
		Collections.sort(cands, (a, b) -> {
			int len1 = dist[a[0]][a[1]];
			int len2 = dist[b[0]][b[1]];
			if (len1 != len2) {
				return Integer.compare(len1, len2);
			}
			if (grid[a[0]][a[1]] != grid[b[0]][b[1]]) {
				return Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]);
			}
			if (a[0] != b[0]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		for (int i = 0; i < Math.min(k, cands.size()); i++) {
			ans.add(Arrays.asList(cands.get(i)[0], cands.get(i)[1]));
		}
		return ans;
	}

	void bfs(int r, int c, int[][] grid, int[][] dist) {
		int n = grid.length, m = grid[0].length;
		Deque<int[]> dq = new ArrayDeque<>();
		int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		dist[r][c] = 0;
		dq.add(new int[] { r, c });
		while (!dq.isEmpty()) {
			int node[] = dq.poll();
			r = node[0];
			c = node[1];
			for (int[] d : d4) {
				int nr = r + d[0], nc = c + d[1];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] == 0
						|| dist[nr][nc] <= dist[r][c] + 1)
					continue;
				dist[nr][nc] = dist[r][c] + 1;
				dq.add(new int[] { nr, nc });
			}
		}
	}
}
