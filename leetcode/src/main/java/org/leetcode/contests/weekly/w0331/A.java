package org.leetcode.contests.weekly.w0331;

import java.util.PriorityQueue;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public long pickGifts(int[] gifts, int k) {
		long ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int g : gifts)
			pq.add(-g);
		for (int i = 0; i < k && !pq.isEmpty(); i++) {
			int cur = -pq.poll();
			int leave = (int) Math.sqrt(cur);
			if (leave > 0)
				pq.add(-leave);
		}
		while (!pq.isEmpty()) {
			ans += -pq.poll();
		}
		return ans;
	}
}
