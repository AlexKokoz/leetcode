package org.leetcode.contests.biweekly.bw0033;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001559_DetectCyclesIn2DGrid {
	static int[][] d4 = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	boolean ok;

	public boolean containsCycle(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] seen = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (seen[i][j])
					continue;
				Deque<int[]> q = new ArrayDeque<>();
				q.add(new int[] {i,j,-1,-1});
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					int r = cur[0];
					int c = cur[1];
					int pr = cur[2];
					int pc = cur[3];
					for(int[] d : d4) {
						int nr = r + d[0];
						int nc = c + d[1];
						if (nr < 0 || nc < 0 || nr >= n || nc >= m || grid[r][c] != grid[nr][nc])continue;
						if (nr == pr && nc == pc) continue;
						if (seen[nr][nc]) return true;
						seen[nr][nc] = true;
						q.add(new int[] {nr,nc,r,c});
					}
				}
				
			}
		}
		return false;
	}

}
