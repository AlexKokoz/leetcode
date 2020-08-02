package org.leetcode.contests.weekly.w0200;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001536_MinimumSwapsToArrangAaBinaryGrid {
	public int minSwaps(int[][] grid) {
		int n = grid.length;
		int ans = 0;
		int[] ct = new int[n]; // consecutive zeros from right
		for (int r = 0; r < n; r++) {
			for (int c = n - 1; c >= 0; c--) {
				if (grid[r][c] == 0)
					ct[r]++;
				else
					break;
			}
		}

		for (int r = 0, expected = n - 1; r < n; r++, expected--) {
			if (ct[r] < expected) {
				int j = r + 1;
				while (j < n && ct[j] < expected)
					j++;
				if (j == n)
					return -1;
				while (j > r) {
					swap(j, j - 1, ct);
					ans++;
					j--;
				}
			}
		}

		return ans;
	}

	static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
