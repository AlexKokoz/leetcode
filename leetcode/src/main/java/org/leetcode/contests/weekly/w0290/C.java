package org.leetcode.contests.weekly.w0290;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int[] countRectangles(int[][] rs, int[][] ps) {
		int np = ps.length;
		int[] ans = new int[np];
		int[][] byy = byy(rs);
		for (int i = 0; i < np; i++) {
			int[] p = ps[i];
			for (int y = byy.length - 1; y > 0 && p[1] <= y; y--) {
				int pos = byy[y].length;
				int lo = 0;
				int hi = byy[y].length - 1;
				while (lo <= hi) {
					int mi = lo + (hi - lo) / 2;
					if (p[0] <= byy[y][mi]) {
						pos = mi;
						hi = mi - 1;
					} else {
						lo = mi + 1;
					}
				}
				ans[i] += byy[y].length - pos;
			}
		}
		return ans;
	}

	int[][] byy(int[][] rs) {
		int maxy = 0;
		for (int[] r : rs)
			maxy = Math.max(maxy, r[1]);
		int[] county = new int[maxy + 1];
		for (int[] r : rs)
			county[r[1]]++;
		int[][] ret = new int[maxy + 1][];
		for (int y = 0; y <= maxy; y++)
			ret[y] = new int[county[y]];
		for (int[] r : rs)
			ret[r[1]][--county[r[1]]] = r[0];
		for (int y = 0; y < ret.length; y++)
			Arrays.sort(ret[y]);
		return ret;
	}
}
