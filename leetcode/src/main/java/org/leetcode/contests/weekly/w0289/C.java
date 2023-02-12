package org.leetcode.contests.weekly.w0289;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maxTrailingZeros(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int ans = 0;
		int max = 0;
		for (int[] row : grid)
			for (int num : row)
				max = Math.max(max, num);
		int[] dp2 = new int[max + 1];
		int[] dp5 = new int[max + 1];
		for (int num = 1; num <= max; num++) {
			int x = num;
			while (x > 0 && x % 2 == 0) {
				x /= 2;
				dp2[num]++;
			}
			while (x > 0 && x % 5 == 0) {
				x /= 5;
				dp5[num]++;
			}
		}
		int[][] rows2 = new int[n][m + 1];
		int[][] rows5 = new int[n][m + 1];
		int[][] cols2 = new int[n + 1][m];
		int[][] cols5 = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				rows2[i][j + 1] = rows2[i][j] + dp2[grid[i][j]];
			for (int j = 0; j < m; j++)
				rows5[i][j + 1] = rows5[i][j] + dp5[grid[i][j]];
		}
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++)
				cols2[i + 1][j] = cols2[i][j] + dp2[grid[i][j]];
			for (int i = 0; i < n; i++)
				cols5[i + 1][j] = cols5[i][j] + dp5[grid[i][j]];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// left + top
				ans = Math.max(ans,
						Math.min(rows2[i][j + 1] + cols2[i][j], rows5[i][j + 1] + cols5[i][j]));

				// left + bottom
				ans = Math.max(ans, Math.min(rows2[i][j + 1] + cols2[n][j] - cols2[i + 1][j],
						rows5[i][j + 1] + cols5[n][j] - cols5[i + 1][j]));

				// right + top
				ans = Math.max(ans, Math.min(rows2[i][m] - rows2[i][j] + cols2[i][j],
						rows5[i][m] - rows5[i][j] + cols5[i][j]));

				// right + bottom
				ans = Math.max(ans, Math.min(rows2[i][m] - rows2[i][j] + cols2[n][j] - cols2[i + 1][j],
						rows5[i][m] - rows5[i][j] + cols5[n][j] - cols5[i + 1][j]));
			}
		}
		return ans;
	}
}
