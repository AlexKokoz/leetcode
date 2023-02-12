package org.leetcode.contests.biweekly.bw0078;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int divisorSubstrings(int num, int k) {
		int ans = 0;
		String s = String.valueOf(num);
		for (int i = 0; i + k <= s.length(); i++) {
			int cand = Integer.parseInt(s.substring(i, i + k));
			if (cand != 0 && num % cand == 0)
				ans++;
		}
		return ans;
	}
}
