package org.leetcode.contests.weekly.w0214;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001647_MinimumDeletionΤοMakeCharacterFrequenciesUnique {
	public int minDeletions(String s) {
		int n = s.length();
		int ans = 0;
		int[] f = new int[26];
		for (int i = 0; i < n; i++)
			f[s.charAt(i) - 'a']++;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int x : f)
			if (x != 0)
				pq.add(-x);
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			if (pq.isEmpty())
				break;
			while (!pq.isEmpty() && pq.peek() == cur) {
				int redacted = pq.poll() + 1;
				if (redacted != 0)
					pq.add(redacted);
				ans++;
			}
		}

		return ans;
	}
}
