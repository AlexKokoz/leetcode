package org.leetcode.contests.biweekly.bw0077;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int countPrefixes(String[] words, String s) {
		int ans = 0;
		for (String w : words) {
			if (s.indexOf(w) == 0)
				ans++;
		}
		return ans;
	}
}
