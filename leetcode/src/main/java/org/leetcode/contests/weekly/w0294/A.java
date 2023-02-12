package org.leetcode.contests.weekly.w0294;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int percentageLetter(String s, char letter) {
		int n = s.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == letter) {
				count++;
			}
		}
		int ans = (int) (100 * ((double) count / n));
		return ans;
	}
}
