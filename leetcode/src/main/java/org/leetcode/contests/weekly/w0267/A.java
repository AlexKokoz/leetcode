package org.leetcode.contests.weekly.w0267;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int timeRequiredToBuy(int[] tickets, int k) {
		int n = tickets.length;
		int[] times = new int[n];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			q.add(i);
		int time = 1;
		while (!q.isEmpty()) {
			int i = q.poll();
			tickets[i]--;
			times[i] = time++;
			if (tickets[i] > 0)
				q.add(i);

		}
		return times[k];
	}
}
