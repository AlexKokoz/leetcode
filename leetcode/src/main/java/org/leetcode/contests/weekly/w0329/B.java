package org.leetcode.contests.weekly.w0329;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[][] sortTheStudents(int[][] score, int k) {
		Arrays.sort(score, (a, b) -> {
			return Integer.compare(b[k], a[k]);
		});
		return score;
	}
}
