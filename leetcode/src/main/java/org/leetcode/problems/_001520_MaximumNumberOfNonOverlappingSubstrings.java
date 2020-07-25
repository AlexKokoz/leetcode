package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001520_MaximumNumberOfNonOverlappingSubstrings {

	public List<String> maxNumOfSubstrings(String s) {

		int n = s.length();
		int[] from = new int[26];
		int[] to = new int[26];

		Arrays.fill(from, -1);
		for (int i = 0; i < n; i++) {
			int id = s.charAt(i) - 'a';
			if (from[id] < 0)
				from[id] = i;
			to[id] = i;
		}

		List<String> ans = new LinkedList<>();
		outer: for (int lo = 0, hi = -1; lo < n; lo++) {
			int cur = s.charAt(lo) - 'a';
			if (from[cur] != lo) continue;
			int nhi = to[cur];
			for (int i = lo + 1; i <= nhi; i++) {
				int ncur = s.charAt(i) - 'a';
				if (from[ncur] < lo) continue outer;
				nhi = Math.max(nhi, to[ncur]);
			}
			String sub = s.substring(lo, nhi + 1);
			if (lo < hi) ans.set(ans.size() - 1, sub);
			else         ans.add(s.substring(lo, nhi + 1));
			hi = nhi;
		}
		return ans;

	}
}
