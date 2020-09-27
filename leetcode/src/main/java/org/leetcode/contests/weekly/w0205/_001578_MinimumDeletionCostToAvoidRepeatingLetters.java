package org.leetcode.contests.weekly.w0205;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001578_MinimumDeletionCostToAvoidRepeatingLetters {
	public int minCost(String s, int[] cost) {
		int ans = 0;
		int n = cost.length;
		int i = 0;
		while(i < n) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.add(cost[i]);
			int j = i + 1;
			while(j < n && s.charAt(j) == s.charAt(i)) {
				pq.add(cost[j]);
				j++;
			}
			while(pq.size() > 1) {
				ans += pq.poll();
			}
			i = j;
		}
		return ans;
	}
}
