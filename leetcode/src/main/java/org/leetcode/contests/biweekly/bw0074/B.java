package org.leetcode.contests.biweekly.bw0074;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public long maximumSubsequenceCount(String text, String pattern) {
		long ans = 0;
		int n = text.length();
		char a = pattern.charAt(0), b = pattern.charAt(1);
		{
			long cand = 0;
			long bcount = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (text.charAt(i) == a) {
					cand += bcount;
				}
				if (text.charAt(i) == b) {
					bcount++;
				}

			}
			cand += bcount;
			ans = Math.max(ans, cand);
		}
		{
			long cand = 0;
			long acount = 0;
			for (int i = 0; i < n; i++) {
				if (text.charAt(i) == b) {
					cand += acount;
				}
				if (text.charAt(i) == a) {
					acount++;
				}

			}
			cand += acount;
			ans = Math.max(ans, cand);
		}
		return ans;
	}
}
