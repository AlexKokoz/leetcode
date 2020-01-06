package org.leetcode.contests.weekly.w0167;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001292_MaxSideSquareWithSumLEToThreshold {

	public int maxSideLength(int[][] mat, int threshold) {
		final int R = mat.length;
		final int C = mat[0].length;
		final int[][] pre = new int[R][C];
		for (int r = 0; r < R; r++) {
			pre[r][0] = mat[r][0];
		}
		for (int r = 0; r < R; r++) {
			for (int c = 1; c < C; c++) {
				pre[r][c] = pre[r][c - 1] + mat[r][c];
			}
		}
		int lo = 0;
		int hi = Math.min(R, C);
		outer: while (lo < hi) {
			int m = (hi + lo) / 2;
			for (int r = 0; r <= R - m; r++) {
				for (int c = 0; c <= C - m; c++) {
					if (pre(pre, r, c, m) <= threshold) {
						lo = m + 1;
						continue outer;
					}
				}
			}
			hi = m - 1;
		}
		return lo;
	}

	static int pre(int[][] pre, int r, int c, int length) {
		int sum = 0;
		int to = c + length - 1;
		for (int nr = r; nr < r + length; nr++) {
			sum += pre[nr][to] - ((c == 0) ? 0 : pre[nr][c - 1]);
		}
		return sum;
	}

}
