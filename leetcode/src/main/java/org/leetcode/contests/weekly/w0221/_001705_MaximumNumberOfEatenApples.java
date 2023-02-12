package org.leetcode.contests.weekly.w0221;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001705_MaximumNumberOfEatenApples {
	public int eatenApples(int[] apples, int[] days) {
		int n = apples.length;
		int ans = 0;
		PriorityQueue<int[]> ad = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		for (int i = 0; i < n; i++) {
			if (apples[i] != 0)
				ad.add(new int[] { apples[i], i + days[i] - 1 });
			while (!ad.isEmpty() && i > ad.peek()[1])
				ad.poll();
			if (!ad.isEmpty()) {
				ans++;
				ad.peek()[0]--;
				if (ad.peek()[0] == 0)
					ad.poll();
			}
		}
		for (int i = n; !ad.isEmpty(); i++) {
			while (!ad.isEmpty() && i > ad.peek()[1])
				ad.poll();
			if (!ad.isEmpty()) {
				ans++;
				ad.peek()[0]--;
				if (ad.peek()[0] == 0)
					ad.poll();
			}
		}

		return ans;
	}
}
