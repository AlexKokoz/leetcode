package org.leetcode.contests.biweekly.bw0026;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001446_ConsecutiveCharacters {
	public int maxPower(String s) {
		int n = s.length();
		int last = -1;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
				max = Math.max(max, i - last);
				last = i;
			}
		}
		return max;
	}
}
