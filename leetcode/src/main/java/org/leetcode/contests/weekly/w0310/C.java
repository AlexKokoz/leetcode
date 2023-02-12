package org.leetcode.contests.weekly.w0310;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int minGroups(int[][] is) {
		int n = is.length;
		int ans = 0;
		int[][] es = new int[2 * n][];
		for (int i = 0; i < n; i++) {
			es[i] = new int[] { is[i][0], 0 };
			es[n + i] = new int[] { is[i][1], 1 };
		}
		Arrays.sort(es, (a, b) -> {
			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			return Integer.compare(a[1], b[1]);
		});
		for (int i = 0, bal = 0; i < es.length; i++) {
			if (es[i][1] == 0) {
				bal++;
			} else {
				bal--;
			}
			ans = Math.max(ans, bal);
		}
		return ans;
	}
}
