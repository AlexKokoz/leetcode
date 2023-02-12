package org.leetcode.contests.biweekly.bw0052;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001861_RotatingTheBox {
	public char[][] rotateTheBox(char[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		char[][] ans = new char[m][n];
		for (int r = 0; r < n; r++) {
			int cc = n - 1 - r;
			int base = m;
			for (int c = m - 1; c >= 0; c--) {
				int rr = c;
				if (mat[r][c] == '.') {
					ans[rr][cc] = '.';
				} else if (mat[r][c] == '*') {
					ans[rr][cc] = '*';
					base = rr;
				} else {
					ans[rr][cc] = '.';
					ans[--base][cc] = '#';
				}
			}
		}
		return ans;
	}
}
