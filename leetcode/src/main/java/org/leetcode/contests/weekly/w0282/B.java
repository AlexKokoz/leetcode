package org.leetcode.contests.weekly.w0282;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minSteps(String s, String t) {
		int ans = 0;
		int[] count = new int[26];
		for (char c : s.toCharArray())
			count[c - 'a']++;
		for (char c : t.toCharArray())
			count[c - 'a']--;
		for (int x : count) {
			ans += Math.abs(x);
		}
		return ans;
	}
}
