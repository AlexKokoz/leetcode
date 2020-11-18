package org.leetcode.contests.weekly.w0214;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001648_SellDiminishingValuedColoredBalls {
	public int maxProfit(int[] inventory, int orders) {
		long mod = 1000000007;
		long ans = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int x : inventory)
			pq.add((long) -x);
		while (!pq.isEmpty() && orders > 0) {
			long cur = -pq.poll();
			long less = pq.isEmpty() ? 0 : -pq.peek();
			if (cur > less) {
				long diff = Math.min(orders, cur - less);
				ans = (ans + sum(cur - diff + 1, cur, mod)) % mod;
				cur -= diff;
				if (cur > 0)
					pq.add(-cur);
				orders -= diff;
			} else {
				int same = 1;
				while (!pq.isEmpty() && pq.peek() == -cur) {
					if (same == orders) {
						ans = (ans + (same * cur) % mod) % mod;
						return (int) ans;
					}
					pq.poll();
					same++;
				}
				less = pq.isEmpty() ? 0 : -pq.peek();
				long diff = Math.min(cur - less, orders / same);
				ans = (ans + (same * sum(cur - diff + 1, cur, mod)) % mod) % mod;
				long rem = cur - diff;
				if (rem > 0) {
					for (int i = 0; i < same; i++)
						pq.add(-rem);
				}
				orders -= same * diff;

			}
		}
		return (int) ans;
	}

	long sum(long from, long to, long mod) {
		long sum = 0;
		sum = to * (to + 1) / 2 % mod;
		sum = (sum - (from * (from - 1) / 2 % mod)) % mod;
		if (sum < 0)
			sum += mod;
		return sum;
	}
}
