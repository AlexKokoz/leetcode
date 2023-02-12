package org.leetcode.contests.weekly.w0216;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001665_MinimumInitialEnergyToFinishTasks {
	public int minimumEffort(int[][] tasks) {
		int ans = 0;
		int bal = 0;
		Arrays.sort(tasks, (a, b) -> {
			int diffa = Math.abs(a[0] - a[1]);
			int diffb = Math.abs(b[0] - b[1]);
			return diffb - diffa;
		});
		for (int[] task : tasks) {
			int max = Math.max(task[0], task[1]);
			int diff = Math.max(0, max - bal);
			bal += diff;
			ans += diff;
			bal -= task[0];
		}
		return ans;
	}
}
