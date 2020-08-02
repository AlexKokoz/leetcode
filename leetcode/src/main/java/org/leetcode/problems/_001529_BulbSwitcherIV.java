package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001529_BulbSwitcherIV {
	public int minFlips(String target) {
		int n = target.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (actual(i, ans) != target.charAt(i)) ans++;
		}
		return ans;
	}

	static char actual(int i, int flips) {
		return flips % 2 == 0 ? '0' : '1';
	}
}
