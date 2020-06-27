package org.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001044_LongestDuplicateSubstring {
	public String longestDupSubstring(String s) {
		int n = s.length();
		int m = 1000000009;
		int p = 31;
		long[] ppow = new long[n];
		long[] h = new long[n + 1];

		ppow[0] = 1;
		for (int i = 1; i < n; i++)
			ppow[i] = (ppow[i - 1] * p) % m;

		for (int i = 0; i < n; i++)
			h[i + 1] = (h[i] + (s.charAt(i) - 'a' + 1) * ppow[i]) % m;

		int lo = 2;
		int hi = n;
		String ans = "";
		while (lo <= hi) {
			int mi = lo + (hi - lo >> 1);
			String candidate = search(s, mi, h, ppow, m);
			if (candidate.length() > ans.length()) {
				ans = candidate;
				lo = mi + 1;
			} else {
				hi = mi - 1;
			}
		}
		return ans;
	}

	String search(String s, int len, long[] h, long[] ppow, int m) {
		int n = s.length();
		Map<Long, Queue<Integer>> map = new HashMap<>();
		for (int i = 0; i <= n - len; i++) {
			long hash = (h[i + len] + m - h[i]) % m;
			hash = (hash * ppow[n - i - 1]) % m;
			Queue<Integer> q = map.getOrDefault(hash, new LinkedList<>());
			if (map.containsKey(hash)) {
				String sub = s.substring(i, i + len);
				for (int pos : q) {
					if (sub.equals(s.substring(pos, pos + len)))
						return sub;
				}
			}
			q.add(i);
			map.put(hash, q);
		}
		return "";
	}
}


