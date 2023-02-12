package org.leetcode.contests.weekly.w0314;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int hardestWorker(int n, int[][] logs) {
		int time = 0;
		int maxTime = 0;
		int ans = -1;
		for (int[] log : logs) {
			int cand = log[1] - time;
			if (cand > maxTime) {
				maxTime = cand;
				ans = log[0];
			} else if (cand == maxTime && log[0] < ans) {
				ans = log[0];
			}
			time = log[1];
		}
		return ans;
	}
}
