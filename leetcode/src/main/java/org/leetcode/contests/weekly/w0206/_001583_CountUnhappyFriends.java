package org.leetcode.contests.weekly.w0206;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001583_CountUnhappyFriends {
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		int ans = 0;
		int[] with = new int[n];
		@SuppressWarnings("unchecked")
		Set<Integer>[] prefers = new Set[n];

		for (int[] pair : pairs) {
			int a = pair[0];
			int b = pair[1];
			with[a] = b;
			with[b] = a;
		}

		for (int p = 0; p < n; p++) {
			prefers[p] = new HashSet<>();
			for (int i = 0; i < n - 1 && preferences[p][i] != with[p]; i++)
				prefers[p].add(preferences[p][i]);
		}

		boolean[] done = new boolean[n];

		for (int p = 0; p < n; p++) {
			if (done[p])
				continue;
			for (int better : prefers[p])
				if (prefers[better].contains(p)) {
					ans += 2;
					done[p] = true;
					done[better] = true;
				}
		}

		return ans;
	}
}
