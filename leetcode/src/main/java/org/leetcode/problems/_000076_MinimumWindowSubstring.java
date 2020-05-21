package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000076_MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int ns = s.length();
		int nt = t.length();
		int[] ct = new int[256];
		for (int i = 0; i < nt; i++) {
			ct[t.charAt(i)]++;
		}
		int count = nt;
		String ans = "";
		int lo = 0;
		int hi = 0;
		while (hi < ns) {
			while (hi < ns && count > 0) {
				char c = s.charAt(hi++);
				if (--ct[c] >= 0) {
					count--;
				}
			}
			if (count == 0 && ans.equals("") || ans.length() > hi - lo) {
				ans = s.substring(lo, hi);
			}
			while (count == 0) {
				char c = s.charAt(lo++);
				if (ct[c]++ >= 0) {
					count++;
				}
			}
			if (ans.length() > hi - lo + 1) {
				ans = s.substring(lo - 1, hi);
			}

		}
		return ans;
	}
}
