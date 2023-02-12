package org.leetcode.contests.weekly.w0294;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(capacity[a] - rocks[a], capacity[b] - rocks[b]);
		});
		int n = rocks.length;
		for (int i = 0; i < n; i++)
			pq.add(i);
		int ans = 0;
		while (!pq.isEmpty() && additionalRocks > 0) {
			int cur = pq.poll();
			int need = capacity[cur] - rocks[cur];
			int take = Math.min(additionalRocks, need);
			if (take == need) {
				ans++;
				additionalRocks -= take;
			} else {
				break;
			}
		}
		return ans;
	}
}
