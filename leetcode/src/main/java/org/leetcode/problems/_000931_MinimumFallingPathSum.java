package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000931_MinimumFallingPathSum {
	public int minFallingPathSum(int[][] a) {
		final int n = a.length;

		for (int r = 1; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int min = Math.min((c - 1 >= 0 ? a[r - 1][c - 1] : Integer.MAX_VALUE),
						Math.min(a[r - 1][c], (c + 1 < n ? a[r - 1][c + 1] : Integer.MAX_VALUE)));
				a[r][c] += min;
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int x : a[n - 1])
			ans = Math.min(ans, x);
		return ans;
	}
}
