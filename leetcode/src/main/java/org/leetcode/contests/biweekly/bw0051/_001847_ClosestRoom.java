package org.leetcode.contests.biweekly.bw0051;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001847_ClosestRoom {
	public int[] closestRoom(int[][] rs, int[][] qs) {
		int nr = rs.length, nq = qs.length;
		int[][] ai = new int[nq][];
		for (int i = 0; i < nq; i++) {
			ai[i] = new int[] { qs[i][0], qs[i][1], i };
		}
		int[] ans = new int[nq];
		Arrays.sort(ai, (a, b) -> {
			return Integer.compare(b[1], a[1]);
		});
		Arrays.sort(rs, (a, b) -> Integer.compare(b[1], a[1]));
		TreeSet<Integer> set = new TreeSet<>();
		int p = 0;
		for (int i = 0; i < nq; i++) {
			int preferred = ai[i][0], minSize = ai[i][1], id = ai[i][2];
			while (p < nr && rs[p][1] >= minSize) {
				set.add(rs[p][0]);
				p++;
			}
			if (set.isEmpty()) {
				ans[id] = -1;
			} else {
				Integer left = set.floor(preferred);
				if (left == null)
					left = 1000000007;
				Integer right = set.ceiling(preferred);
				if (right == null)
					right = 1000000007;
				if (Math.abs(left - preferred) <= Math.abs(right - preferred)) {
					ans[id] = left;
				} else
					ans[id] = right;
			}
		}
		return ans;
	}
}
