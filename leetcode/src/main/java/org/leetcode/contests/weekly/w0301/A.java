package org.leetcode.contests.weekly.w0301;

import java.util.PriorityQueue;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int fillCups(int[] amount) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		int ans = 0;
		for (int x : amount)
			if (x > 0)
				pq.add(x);
		while (pq.size() > 1) {
			int a1 = pq.poll() - 1;
			int a2 = pq.poll() - 1;
			ans++;
			if (a1 > 0)
				pq.add(a1);
			if (a2 > 0)
				pq.add(a2);
		}
		if (!pq.isEmpty()) {
			ans += pq.peek();
		}
		return ans;
	}
}
