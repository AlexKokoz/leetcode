package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001528_ShuffleString {
	public String restoreString(String s, int[] indices) {
		int n = s.length();
		char[] ans = new char[n];
		for (int i = 0; i < n; i++) {
			ans[indices[i]] = s.charAt(i);
		}
		return String.valueOf(ans);
	}
}
