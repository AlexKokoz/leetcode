package org.leetcode.contests.weekly.w0290;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
		int nf = flowers.length;
		int np = persons.length;
		int[] ans = new int[np];
		int[][] es = new int[2 * nf][];
		for (int i = 0; i < nf; i++) {
			es[i] = new int[] { flowers[i][0], 0 };
			es[nf + i] = new int[] { flowers[i][1] + 1, 1 };
		}
		Arrays.sort(es, (a, b) -> {
			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			return Integer.compare(b[1], a[1]);
		});
		int[][] ai = new int[np][];
		for (int i = 0; i < np; i++) {
			ai[i] = new int[] { persons[i], i };
		}
		Arrays.sort(ai, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});
		for (int i = 0, j = 0, fs = 0; i < np; i++) {
			while (j < es.length && es[j][0] <= ai[i][0]) {
				if (es[j][1] == 0)
					fs++;
				else
					fs--;
				j++;
			}
			ans[ai[i][1]] = fs;
		}
		return ans;
	}
}
