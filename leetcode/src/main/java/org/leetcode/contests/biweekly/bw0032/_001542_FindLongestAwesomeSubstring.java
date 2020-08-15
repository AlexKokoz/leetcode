package org.leetcode.contests.biweekly.bw0032;

import java.util.*;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001542_FindLongestAwesomeSubstring {
	public int longestAwesome(String s) {
		int n = s.length();
		Map<Integer, Integer> map = new HashMap<>();
		int mask = 0;
		int ans = 1;
		map.put(mask, -1);
		for (int i = 0; i < n; i++) {
			int c = s.charAt(i) - '0';
			mask ^= (1 << c);
			if (!map.containsKey(mask)) map.put(mask, i);
			else                        ans = Math.max(ans, i - map.get(mask));
			int mask2 = mask;
			for (int d = 0; d < 10; d++) {
				int mask3 = mask2 ^ (1 << d);
				if (map.containsKey(mask3)) {
					ans = Math.max(ans, i - map.get(mask3));
				}
			}
		}
		return ans;
	}
}
