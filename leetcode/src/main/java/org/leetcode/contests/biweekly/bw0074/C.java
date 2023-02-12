package org.leetcode.contests.biweekly.bw0074;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int halveArray(int[] nums) {
		int ans = 0;
		PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
		long total = 0;
		for (int num : nums) {
			pq.add((double) num);
			total += num;
		}
		double half = total / 2.0;
		while (half > 0) {
			double cur = pq.poll();
			cur /= 2;
			half -= cur;
			pq.add(cur);
			ans++;
		}
		return ans;
	}
}
