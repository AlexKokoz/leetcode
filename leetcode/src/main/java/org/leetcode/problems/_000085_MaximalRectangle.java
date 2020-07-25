package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000085_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int n = matrix.length;
		if (n == 0) return 0;
		int m = matrix[0].length;
		if (m == 0) return 0;

		int ans = 0;
		
		int[] h = new int[m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				h[c] = matrix[r][c] == '1' ? h[c] + 1 : 0;
			}

			// index of first less h element from left
			int[] lessFromLeft = new int[m];
			lessFromLeft[0] = -1;
			for (int c = 1; c < m; c++) {
				int cur = c - 1;
				while (cur >= 0 && h[cur] >= h[c])
					cur = lessFromLeft[cur];
				lessFromLeft[c] = cur;
			}

			// index of first less h element from right
			int[] lessFromRight = new int[m];
			lessFromRight[m - 1] = m;
			for (int c = m - 2; c >= 0; c--) {
				int cur = c + 1;
				while (cur < m && h[cur] >= h[c])
					cur = lessFromRight[cur];
				lessFromRight[c] = cur;
			}

			for (int c = 0; c < m; c++) {
				if (matrix[r][c] != '1')
					continue;
				ans = Math.max(ans, h[c] * (lessFromRight[c] - lessFromLeft[c] - 1));
			}
		}

		return ans;
	}
}
