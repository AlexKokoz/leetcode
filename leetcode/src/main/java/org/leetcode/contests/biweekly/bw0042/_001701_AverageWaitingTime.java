package org.leetcode.contests.biweekly.bw0042;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001701_AverageWaitingTime {
	public double averageWaitingTime(int[][] customers) {
		int n = customers.length;
		long sum = 0;
		int time = 0;
		for (int[] c : customers) {
			time = Math.max(time, c[0]) + c[1];
			sum += time - c[0];
		}
		return (double) sum / n;
	}
}
