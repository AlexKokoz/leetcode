package org.leetcode.contests.biweekly.bw0041;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001686_StoneGameVI {
	public int stoneGameVI(int[] aliceValues, int[] bobValues) {
		int n = aliceValues.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int sum1 = aliceValues[a] + bobValues[a];
			int sum2 = aliceValues[b] + bobValues[b];
			if (sum1 != sum2) return Integer.compare(sum2, sum1);
			int diff1 = Math.abs(aliceValues[a] - bobValues[a]);
			int diff2 = Math.abs(aliceValues[b] - bobValues[b]);
			return Integer.compare(diff1,  diff2);
		});
		for(int i = 0; i < n; i++) pq.add(i);

		int a = 0, b = 0;
		boolean alice = true;
		while(!pq.isEmpty()) {
			int val = pq.poll();
			if (alice) {
				a += aliceValues[val];
			} else {
				b += bobValues[val];
			}
			alice = !alice;
		}
		
		return a > b ? 1 : a < b ? -1 : 0;
	}
}
