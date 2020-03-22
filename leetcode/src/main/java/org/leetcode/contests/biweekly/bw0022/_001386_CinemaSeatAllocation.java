package org.leetcode.contests.biweekly.bw0022;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001386_CinemaSeatAllocation {
	public int maxNumberOfFamilies(int n, int[][] arr) {
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : 0;
			}
		});
		int ans = 0;
		int rows = 0;
		boolean[] marked = new boolean[11];
		for (int i = 0; i < arr.length; i++) {
			marked[arr[i][1]] = true;
			if ((i < arr.length - 1 && arr[i][0] != arr[i + 1][0]) || i == arr.length - 1) {
				int temp = 0;
				if (!marked[2] && !marked[3] && !marked[4] && !marked[5])
					temp++;
				if (!marked[6] && !marked[7] && !marked[8] && !marked[9])
					temp++;
				if (temp == 0)
					if (!marked[4] && !marked[5] && !marked[6] && !marked[7])
						temp++;
				ans += temp;
				rows++;
				marked = new boolean[11];
			}
		}
		ans += (n - rows) * 2;
		return ans;
	}
}
