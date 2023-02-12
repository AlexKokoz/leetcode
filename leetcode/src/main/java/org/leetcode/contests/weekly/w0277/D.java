package org.leetcode.contests.weekly.w0277;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int maximumGood(int[][] ss) {
		int n = ss.length;
		Integer[] masks = new Integer[1 << n];
		for (int i = 0; i < 1 << n; i++) {
			masks[i] = i;
		}
		Arrays.sort(masks, (a, b) -> {
			return Integer.compare(Integer.bitCount(b), Integer.bitCount(a));
		});
		for (int mask : masks) {
			if (ok(mask, ss)) {
				return Integer.bitCount(mask);
			}
		}
		return 0;
	}

	boolean ok(int mask, int[][] ss) {
		int n = ss.length;
		boolean[] good = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (mask << ~i < 0)
				good[i] = true;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ss[i][j] == 2)
					continue;
				else if (ss[i][j] == 0) {
					if (good[i] && good[j]) {
						return false;
					}
				} else { // ss[i][j] == 1
					if (good[i] && !good[j]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
