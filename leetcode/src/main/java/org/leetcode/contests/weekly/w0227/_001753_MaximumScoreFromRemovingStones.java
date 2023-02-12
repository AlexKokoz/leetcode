package org.leetcode.contests.weekly.w0227;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001753_MaximumScoreFromRemovingStones {
	public int maximumScore(int a, int b, int c) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(-a);
		pq.add(-b);
		pq.add(-c);
		int ans = 0;
		while (pq.size() > 1) {
			int x = -pq.poll() - 1;
			int y = -pq.poll() - 1;
			ans++;
			if (x > 0)
				pq.add(-x);
			if (y > 0)
				pq.add(-y);
		}
		return ans;
	}
}
