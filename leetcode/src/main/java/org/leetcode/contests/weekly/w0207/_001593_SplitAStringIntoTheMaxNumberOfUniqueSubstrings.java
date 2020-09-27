package org.leetcode.contests.weekly.w0207;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001593_SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

	public int maxUniqueSplit(String s) {
		int n = s.length();
		int max = 0;
		outer: for (int i = 0; i <= (1 << (n + 1)); i++) {
			int cand = 0;
			StringBuilder sb = new StringBuilder();
			Set<String> set = new HashSet<>();
			sb.append(s.charAt(0));
			for (int j = 1; j < n; j++) {
				int b1 = i  & (1 << j);
				int b2 = i  & (1 << (j - 1));
				if (b1 != b2) {
					if (set.contains(sb.toString()))
						continue outer;
					cand++;
					set.add(sb.toString());
					sb = new StringBuilder();
				}
				sb.append(s.charAt(j));
			}
			if (set.contains(sb.toString()))
				continue outer;
			cand++;

			max = Math.max(max, cand);
		}
		return max;
	}
}
