package org.leetcode.contests.biweekly.bw0023;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001400_ConstructKPalindromeStrings {
	public boolean canConstruct(String s, int k) {
		int n = s.length();
		if (k > n)
			return false;
		if (k == n)
			return true;
		int[] f = new int[26];
		for (int i = 0; i < n; i++)
			f[s.charAt(i) - 'a']++;
		int singles = 0;
		for (int x : f)
			if ((x & 1) > 0)
				singles++;
		return singles <= k;
	}
}
