package org.leetcode.contests.biweekly.bw0081;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int countAsterisks(String s) {
		boolean open = false;
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '|') {
				open = !open;
			} else if (s.charAt(i) == '*' && !open) {
				ans++;
			}
		}
		return ans;
	}
}
