package org.leetcode.contests.weekly.w0292;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	boolean found;
	Set<Long> hist;
	int n, m;
	int[][] d2 = { { 0, 1 }, { 1, 0 } };
	char[][] grid;

	public boolean hasValidPath(char[][] grid) {
		this.grid = grid;
		n = grid.length;
		m = grid[0].length;
		if (grid[0][0] == ')' || grid[n - 1][m - 1] == '(')
			return false;
		hist = new HashSet<>();
		dfs(0, 0, 1, 0);
		return found;
	}

	void dfs(int r, int c, int op, int cl) {
		if (found)
			return;
		if (r == n - 1 && c == m - 1 && op == cl) {
			found = true;
			return;
		}
		for (int[] d : d2) {
			int nr = r + d[0], nc = c + d[1];
			if (nr < n && nc < m) {
				int nop = op, ncl = cl;
				if (grid[nr][nc] == '(')
					nop++;
				else
					ncl++;
				if (ncl > nop)
					continue;
				int rem = n - r + m - c - 2;
				if (nop - ncl > rem)
					continue;
				long key = enc(nr, nc, nop, ncl);
				if (hist.contains(key))
					continue;
				hist.add(key);
				dfs(nr, nc, nop, ncl);
			}
		}
	}

	long enc(int r, int c, int op, int cl) {
		long pos = (long) r << 8 | c;
		long state = (long) op << 8 | cl;
		long ret = pos << 32 | state;
		return ret;
	}
}
