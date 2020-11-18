package org.leetcode.contests.weekly.w0213;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001642_FurthestBuildingYouCanReach {
	int[] h;
	int b;
	int l;

	public int furthestBuilding(int[] h, int bricks, int ladders) {
		this.h = h;
		b = bricks;
		l = ladders;
		int n = h.length;
		int lo = 0;
		int hi = n - 1;
		int best = 0;
		while (lo <= hi) {
			int mi = lo + (hi - lo >>> 1);
			if (check(mi)) {
				best = mi;
				lo = mi + 1;
			} else {
				hi = mi - 1;
			}
		}
		return best;
	}

	boolean check(int i) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int j = 1; j <= i; j++) {
			if (h[j] > h[j - 1])
				pq.add(-(h[j] - h[j - 1]));
		}
		int ll = l;
		while (!pq.isEmpty() && ll > 0) {
			pq.poll();
			ll--;
		}
		int want = 0;
		while (!pq.isEmpty())
			want += -pq.poll();
		if (want > b)
			return false;
		return true;
	}

}
