package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000567_PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		if (n1 > n2)
			return false;
		int[] ct = new int[26];
		for (int i = 0; i < n1; i++) {
			ct[s1.charAt(i) - 'a']++;
		}
		int count = n1;
		int lo = 0;
		int hi = 0;
		while (hi < n2) {
			if (hi - lo == n1 && ct[s2.charAt(lo++) - 'a']++ >= 0) {
				count++;
			}
			if (--ct[s2.charAt(hi++) - 'a'] >= 0) {
				count--;
			}
			if (count == 0) {
				return true;
			}
		}
		return false;
	}
}
