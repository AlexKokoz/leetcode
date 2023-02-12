package org.leetcode.contests.biweekly.bw0043;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001719_NumberOfWaysToReconstructATree {

	public int checkWays(int[][] pairs) {
		int n = 501;
		// calculate degrees
		int[] deg = new int[n];
		for (int[] pair : pairs) {
			deg[pair[0]]++;
			deg[pair[1]]++;
		}
		// graph
		boolean[][] g = new boolean[n][n];
		for (int[] pair : pairs) {
			g[pair[0]][pair[1]] = g[pair[1]][pair[0]] = true;
		}
		// degree-index array
		int[][] di = new int[n][2];
		for (int i = 0; i < n; i++) {
			di[i] = new int[] { deg[i], i };
		}
		// sort by descending degree and ascending index
		Arrays.sort(di, (a, b) -> {
			return a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]);
		});
		// find closest parents
		int[] par = new int[n];
		Arrays.fill(par, -1);
		for (int ch = 0; ch < n; ch++) {
			for (int p = ch - 1; p >= 0; p--) {
				if (g[di[p][1]][di[ch][1]]) {
					par[di[ch][1]] = di[p][1];
					break;
				}
			}
		}
		// connect every node with its ancestors
		boolean[][] h = new boolean[n][n];
		for(int ch = 0; ch < n; ch++) {
			for(int p = par[ch]; p != -1; p = par[p]) {
				h[p][ch] = h[ch][p] = true;
			}
		}
		// check if at least one rooted tree can be constructed
		for(int i = 0; i < n; i++) {
			if (!Arrays.equals(g[i], h[i])) {
				return 0;
			}
		}
		// 2nd parents with decreasing degree and decreasing index
		Arrays.sort(di, (a, b) -> {
			return a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]);
		});
		int[] par2 = new int[n];
		Arrays.fill(par2, -1);
		for(int ch = 0; ch < n; ch++) {
			for(int p = ch - 1; p >= 0; p--) {
				if (g[di[ch][1]][di[p][1]]) {
					par2[di[ch][1]] = di[p][1];
					break;
				}
			}
		}
		return Arrays.equals(par, par2) ? 1 : 2;
	}
}
