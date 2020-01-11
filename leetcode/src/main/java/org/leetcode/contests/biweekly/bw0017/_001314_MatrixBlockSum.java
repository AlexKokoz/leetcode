package org.leetcode.contests.biweekly.bw0017;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001314_MatrixBlockSum {

	public int[][] matrixBlockSum(int[][] mat, int K) {
		int nr = mat.length;
		if (nr == 0)
			return new int[0][0];
		int nc = mat[0].length;
		int[][] cum = cum(mat);

		int[][] ans = new int[nr][nc];
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				int mainSum = getCum(r + K, c+ K, cum);
				int leftSum = getCum(r + K, c - K - 1, cum);
				int upperSum = getCum(r - K - 1, c+ K , cum);
				int upperDiagSum = getCum(r - K - 1, c - K - 1, cum);
				ans[r][c] = mainSum - leftSum - upperSum + upperDiagSum;
			}
		}
		return ans;
	}

	static int[][] cum(int[][] a) {
		int n = a.length, m = a[0].length;
		int[][] cum = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cum[i + 1][j + 1] = cum[i + 1][j] + cum[i][j + 1] - cum[i][j] + a[i][j];
			}
		}
		int[][] ans = new int[n][m];
		for (int r = 0; r < n; r++)
			for (int c = 0; c < m; c++)
				ans[r][c] = cum[r + 1][c + 1];
		return ans;
	}

	static int getCum(int r, int c, int[][] cum) {
		int nr = cum.length;
		if (nr == 0)
			return 0;
		int nc = cum[0].length;
		if (nc == 0)
			return 0;
		if (r < 0 || c < 0)
			return 0;
		int rr = Math.min(nr - 1, r);
		int cc = Math.min(nc - 1, c);
		
		return cum[rr][cc];

	}
}
