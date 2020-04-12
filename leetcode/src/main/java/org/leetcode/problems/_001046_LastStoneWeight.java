package org.leetcode.problems;

import java.util.PriorityQueue;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001046_LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int stone : stones)
			pq.add(-stone);
		while (pq.size() > 1) {
			int diff = Math.abs(pq.poll() - pq.poll());
			if (diff > 0)
				pq.add(-diff);
		}
		return pq.isEmpty() ? 0 : -pq.poll();
	}
}
