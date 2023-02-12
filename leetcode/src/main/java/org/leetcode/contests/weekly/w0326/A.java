package org.leetcode.contests.weekly.w0326;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int countDigits(int num) {
		int ans = 0;
		String s = "" + num;
		for (char c : s.toCharArray()) {
			int d = c - '0';
			if (num % d == 0)
				ans++;
		}
		return ans;
	}
}
