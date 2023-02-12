package org.leetcode.contests.weekly.w0310;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int partitionString(String s) {
		int n = s.length();
		int ans = 0;
		for (int l = 0; l < n;) {
			int r = l;
			int mask = 0;
			while (r < n && (mask << ~(s.charAt(r) - 'a')) >= 0) {
				mask |= 1 << (s.charAt(r) - 'a');
				r++;
			}
			ans++;
			l = r;
		}
		return ans;
	}
}
