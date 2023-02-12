package org.leetcode.contests.weekly.w0267;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public String decodeCiphertext(String enc, int rows) {
		StringBuilder sb = new StringBuilder();
		int n = enc.length();
		int cols = (int) Math.ceil((double) n / rows);
		char[][] mat = new char[rows][cols];
		for (int i = 0, p = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mat[i][j] = enc.charAt(p++);
			}
		}
		for (int cc = 0; cc < cols; cc++) {
			int c = cc;
			int r = 0;
			while (r < rows && c < cols) {
				sb.append(mat[r][c]);
				r++;
				c++;
			}
		}
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ')
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
