package org.leetcode.contests.weekly.w0314;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[] findArray(int[] pref) {
		int n = pref.length;
		int[] ans = new int[n];
		int xor = 0;
		for (int i = 0; i < n; i++) {
			ans[i] = pref[i] ^ xor;
			xor ^= ans[i];
		}
		return ans;
	}
}
