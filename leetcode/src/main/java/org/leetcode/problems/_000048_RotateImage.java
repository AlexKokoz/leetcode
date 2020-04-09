package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000048_RotateImage {
	public static void rotate(int[][] a) {
		final int n = a.length;
		for (int layer = 0; layer <= n / 2; layer++) {
			for (int c = layer; c <= n - layer - 2; c++) {
				swap(a, layer, c, c, n - 1 - layer);
				swap(a, layer, c, n - 1 - layer, n - 1 - c);
				swap(a, layer, c, n - 1 - c, layer);

			}
		}
	}

	static void swap(int[][] arr, int r1, int c1, int r2, int c2) {
		int swap = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = swap;
	}

}
