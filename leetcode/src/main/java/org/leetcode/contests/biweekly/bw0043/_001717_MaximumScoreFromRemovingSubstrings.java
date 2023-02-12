package org.leetcode.contests.biweekly.bw0043;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001717_MaximumScoreFromRemovingSubstrings {
	public int maximumGain(String s, int x, int y) {
		return Math.max(go(s, x, y, 'a', 'b'), go(s, y, x, 'b', 'a'));
	}

	static int go(String s, int x, int y, char cx, char cy) {
		int cost = 0;
		char[] cs = new char[s.length()];
		int p = 0;
		for (char c : s.toCharArray()) {
			if (c != cx && c != cy) {
				cs[p++] = c;
				continue;
			}
			if (p > 0 && cs[p - 1] == cx && c == cy) {
				cost += x;
				p--;
			} else {
				cs[p++] = c;
			}
		}
		cs = Arrays.copyOf(cs, p);
		char[] cs2 = new char[p];
		p = 0;
		for (char c : cs) {
			if (c != cx && c != cy) {
				cs2[p++] = c;
				continue;
			}
			if (p > 0 && cs2[p - 1] == cy && c == cx) {
				cost += y;
				p--;
			} else {
				cs2[p++] = c;
			}
		}
		return cost;
	}
}
