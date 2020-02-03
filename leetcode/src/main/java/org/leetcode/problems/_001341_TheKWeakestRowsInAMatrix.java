package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001341_TheKWeakestRowsInAMatrix {
	public int[] kWeakestRows(int[][] mat, int k) {
		int nr = mat.length;
		int nc = mat[0].length;
		int[][] temp = new int[nr][2];
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (mat[r][c] == 0)
					break;
				temp[r][0]++;
			}
			temp[r][1] = r;
		}
		Arrays.sort(temp, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] < b[0])
					return -1;
				if (a[0] > b[0])
					return 1;
				if (a[1] < b[1])
					return -1;
				if (a[1] > b[1])
					return 1;
				return 0;
			}
		});

		int[] ans = new int[k];
		for (int i = 0; i < k; i++)
			ans[i] = temp[i][1];
		return ans;
	}
}
