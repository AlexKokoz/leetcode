package org.leetcode.contests.weekly.w0306;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int edgeScore(int[] edges) {
		int n = edges.length;
		long[] score = new long[n];
		for (int i = 0; i < n; i++) {
			score[edges[i]] += i;
		}
		int ans = 0;
		long maxScore = 0;
		for (int i = 0; i < n; i++) {
			if (score[i] > maxScore) {
				ans = i;
				maxScore = score[i];
			}
		}
		return ans;
	}
}
