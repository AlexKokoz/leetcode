package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000451_SortCharactersByFrequency {
	public String frequencySort(String s) {
		int n = s.length();
		int[][] ia = new int[256][2];
		int p = 0;
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			ia[c][0] = c;
			if (ia[c][1] == 0)
				p++;
			ia[c][1]++;
		}
		Arrays.sort(ia, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});
		ia = Arrays.copyOf(ia, p);
		StringBuilder sb = new StringBuilder();
		for (int[] row : ia) {
			char c = (char) row[0];
			for (int i = 0; i < row[1]; i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
