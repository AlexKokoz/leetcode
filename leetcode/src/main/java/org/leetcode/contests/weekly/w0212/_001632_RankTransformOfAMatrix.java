package org.leetcode.contests.weekly.w0212;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001632_RankTransformOfAMatrix {

	public int[][] matrixRankTransform(int[][] mat) {
		int n = mat.length, m = mat[0].length;
		int[][] ans = new int[n][m];
		int[][] ai = new int[n * m][];
		int p = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				ai[p++] = new int[] { mat[r][c], r, c };
			}
		}
		Arrays.sort(ai, (a, b) -> a[0] - b[0]);

		int[] rowmax = new int[n];
		int[] colmax = new int[m];
		int i = 0;
		while (i < ai.length) {
			int j = i;
			while (j < ai.length && ai[j][0] == ai[i][0])
				j++;

			for (int k = i; k < j; k++) {
				int r = ai[k][1];
				int c = ai[k][2];
				int rank = Math.max(rowmax[r] + 1, colmax[c] + 1);
				ans[r][c] = rank;
			}

			while (true) {

				for (int k = i; k < j; k++) {
					int r = ai[k][1];
					int c = ai[k][2];
					rowmax[r] = Math.max(rowmax[r], ans[r][c]);
					colmax[c] = Math.max(colmax[c], ans[r][c]);
				}

				boolean changed = false;
				for (int k = i; k < j; k++) {
					int r = ai[k][1];
					int c = ai[k][2];
					if (rowmax[r] > ans[r][c] || colmax[c] > ans[r][c]) {
						ans[r][c] = Math.max(rowmax[r], colmax[c]);
						changed = true;
					}
				}
				if (!changed)
					break;
			}
			i = j;
		}

		return ans;
	}
}
