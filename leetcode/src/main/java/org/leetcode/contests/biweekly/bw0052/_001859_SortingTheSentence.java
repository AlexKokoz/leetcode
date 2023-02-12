package org.leetcode.contests.biweekly.bw0052;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001859_SortingTheSentence {
	public String sortSentence(String s) {
		String[] ws = s.split(" ");
		String[][] ai = new String[ws.length][2];
		for (int i = 0; i < ws.length; i++) {
			int j = 0;
			while (j < ws[i].length() && ws[i].charAt(j) < '0' || ws[i].charAt(j) > '9') {
				j++;
			}
			ai[i][0] = ws[i].substring(0, j);
			ai[i][1] = ws[i].substring(j, ws[i].length());
		}
		Arrays.sort(ai, (a, b) -> {
			Integer aa = Integer.parseInt(a[1]);
			Integer bb = Integer.parseInt(b[1]);
			return Integer.compare(aa, bb);
		});
		StringBuilder sb = new StringBuilder();
		String sep = "";
		for (String[] row : ai) {
			sb.append(sep).append(row[0]);
			sep = " ";
		}
		return sb.toString();
	}
}
