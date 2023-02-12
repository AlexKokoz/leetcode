package org.leetcode.contests.weekly.w0284;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
		int[][] count = new int[n][n];
		for (int[] rc : dig) {
			count[rc[0]][rc[1]] = 1;
		}
		long[][] cum = cum(count);
		int ans = 0;
		for (int[] a : artifacts) {
			long expected = (a[2] - a[0] + 1) * (a[3] - a[1] + 1);
			long actual = cum[a[2] + 1][a[3] + 1] - cum[a[2] + 1][a[1]] - cum[a[0]][a[3] + 1]
					+ cum[a[0]][a[1]];
			if (expected == actual)
				ans++;
		}
		return ans;

	}

	public static long[][] cum(int[][] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException("argument is null");
		int nr = arr.length, nc = arr[0].length;
		long[][] cum = new long[nr + 1][nc + 1];
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				cum[r + 1][c + 1] = arr[r][c] + cum[r][c + 1] + cum[r + 1][c] - cum[r][c];
			}
		}
		return cum;
	}

}
