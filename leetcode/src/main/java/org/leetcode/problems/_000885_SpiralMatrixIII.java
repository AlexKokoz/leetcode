package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000885_SpiralMatrixIII {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[][] ans = new int[R * C][2];
		int[] steps = new int[] { 1, 1, 2, 2 };
		ans[0] = new int[] { r0, c0 };
		for (int i = 1, d = 0, r = r0, c = c0; i < ans.length;) {
			for (int j = 0; j < steps[d]; j++) {
				r = r + dir[d][0];
				c = c + dir[d][1];
				if (valid(r, c, R, C)) {
					ans[i++] = new int[] { r, c };
				}
			}
			steps[d] += 2;
			d++;
			if (d >= 4) d = 0;
		}
		return ans;
	}

	boolean valid(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
