package org.leetcode.contests.weekly.w0224;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001727_LargestSubmatrixWithRearrangements {
	public int largestSubmatrix(int[][] mat) {
		int ans = 0;
		int n = mat.length;
		if (n == 0)
			return 0;
		int m = mat[0].length;
		for (int r = 1; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (mat[r][c] == 1)
					mat[r][c] += mat[r - 1][c];
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			int[] hs = new int[m];
			int p = 0;
			for (int j = 0; j < m; j++) {
				if (mat[i][j] > 0)
					hs[p++] = mat[i][j];
			}
			hs = Arrays.copyOf(hs, p);
			Arrays.sort(hs);
			for (int k = p - 1, h = Integer.MAX_VALUE; k >= 0; k--) {
				h = Math.min(hs[k], h);
				ans = Math.max(ans, h * (p - k));
			}
		}
		return ans;
	}
}
