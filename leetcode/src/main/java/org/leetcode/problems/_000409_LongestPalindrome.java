package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000409_LongestPalindrome {
	public int longestPalindrome(String s) {
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		boolean odd = false;
		for (int v : map.values()) {
			if (v % 2 == 1) {
				odd = true;
				ans += v - 1;
			} else {
				ans += v;
			}
		}
		if (odd)
			ans++;
		return ans;
	}
}
