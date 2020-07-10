package org.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001499_MaxValueOfEquation {
	public int findMaxValueOfEquation(int[][] points, int k) {
		Deque<long[]> dq = new ArrayDeque<>(); // [x, y - x]
		long ans = Long.MIN_VALUE;
		for (int[] point : points) {
			int x = point[0];
			int y = point[1];
			while(!dq.isEmpty() && x - dq.peekFirst()[0] > k) 
				dq.pollFirst();
			if (!dq.isEmpty())
				ans = Math.max(ans, x + y + dq.peekFirst()[1]);
			while(!dq.isEmpty() && dq.peekLast()[1] < y - x)
				dq.pollLast();
			dq.addLast(new long[] {x, y - x});
		}
		return (int)ans;
	}
}
