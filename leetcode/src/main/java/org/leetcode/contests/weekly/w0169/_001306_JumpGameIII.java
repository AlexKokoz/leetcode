package org.leetcode.contests.weekly.w0169;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001306_JumpGameIII {
	public boolean canReach(int[] a, int start) {
		final int n = a.length;
		if (n == 0)
			return false;
		if (a[start] == 0)
			return true;
		final boolean[] marked = new boolean[n];
		final Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				marked[i] = true;
				q.add(i);
			}
		}
		if (q.size() == 0)
			return false;
		while (!q.isEmpty()) {
			final int i = q.poll();
			int k = 1;
			int lo = i - k;
			int hi = i + k;
			while (lo >= 0 || hi < n) {
				if (lo >= 0 && a[lo] == k && !marked[lo]) {
					if (lo == start)
						return true;
					q.add(lo);
					marked[lo] = true;
				}

				if (hi < n && a[hi] == k && !marked[hi]) {
					if (hi == start)
						return true;
					q.add(hi);
					marked[hi] = true;
				}
				k++;
				lo--;
				hi++;
			}
		}
		return false;
	}
}
