package org.leetcode.contests.biweekly.bw0086;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maximumRows(int[][] mat, int cols) {
		int m = mat[0].length;
		int ans = 0;
		for (int mask = 1; mask < 1 << m; mask++) {
			if (Integer.bitCount(mask) != cols)
				continue;
			int cand = 0;
			for (int[] row : mat) {
				boolean ok = true;
				for (int c = 0; c < m; c++) {
					if (mask << ~c >= 0 && row[c] == 1) {
						ok = false;
						break;
					}
				}
				if (ok)
					cand++;
			}
			ans = Math.max(ans, cand);
		}
		return ans;
	}
}
