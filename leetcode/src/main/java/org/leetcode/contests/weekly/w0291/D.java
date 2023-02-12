package org.leetcode.contests.weekly.w0291;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long appealSum(String s) {
		int n = s.length();
		long ans = 0;
		int[] last = new int[26];
		Arrays.fill(last, -1);
		for (int i = 0; i < n; i++) {
			long left = last[s.charAt(i) - 'a'];
			long right = n;
			ans += (right - i) * (i - left);
			last[s.charAt(i) - 'a'] = i;
		}
		return ans;
	}
}
