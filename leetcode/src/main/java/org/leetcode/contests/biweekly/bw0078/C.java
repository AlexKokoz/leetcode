package org.leetcode.contests.biweekly.bw0078;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
		Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));
		int n = tiles.length;
		long ans = 0;
		long[] cum = new long[n + 1];
		for (int i = 0; i < n; i++)
			cum[i + 1] = cum[i] + tiles[i][1] - tiles[i][0] + 1;
		for (int i = 0; i < n; i++) {
			int j = i - 1;
			int lo = i;
			int hi = n - 1;
			while (lo <= hi) {
				int mi = lo + (hi - lo) / 2;
				if (tiles[i][0] + carpetLen > tiles[mi][1]) {
					j = mi;
					lo = mi + 1;
				} else {
					hi = mi - 1;
				}
			}
			long cand = 0;
			if (j >= i) {
				cand += cum[j + 1] - cum[i];
			}
			if (j < n - 1 && tiles[i][0] + carpetLen >= tiles[j + 1][0]) {
				cand += tiles[i][0] + carpetLen - tiles[j + 1][0];
			}
			ans = Math.max(ans, cand);
		}
		return (int) ans;
	}
}
