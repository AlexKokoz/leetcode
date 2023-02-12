package org.leetcode.contests.weekly.w0282;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int prefixCount(String[] words, String pref) {
		int ans = 0;
		for (String w : words) {
			if (w.indexOf(pref) == 0)
				ans++;
		}
		return ans;
	}
}
