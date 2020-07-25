package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001513_NumberOfSubstringsWithOnly1s {
	public int numSub(String s) {
		int prev = -1;
		long ans = 0;
		long mod = 1000000007;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				if (i > 0 && s.charAt(i - 1) == '0') {
					prev = i - 1;
				}
				if (i == s.length() - 1 || s.charAt(i + 1) == '0') {
					long len = i - prev;
					ans += len* (len + 1) / 2;
				}

			}
		}
		return (int) (ans % mod);
	}
}
