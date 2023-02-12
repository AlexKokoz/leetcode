package org.leetcode.contests.weekly.w0311;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int longestContinuousSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n;) {
			int j = i + 1;
			while (j < n && s.charAt(j) - s.charAt(j - 1) == 1) {
				j++;
			}
			ans = Math.max(ans, j - i);
			i = j;
		}
		return ans;
	}
}
