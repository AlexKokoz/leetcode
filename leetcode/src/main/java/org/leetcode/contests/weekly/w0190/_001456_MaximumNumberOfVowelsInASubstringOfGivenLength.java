package org.leetcode.contests.weekly.w0190;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001456_MaximumNumberOfVowelsInASubstringOfGivenLength {
	public int maxVowels(String s, int k) {
		String v = "aeiou";
		int n = s.length();
		int[] ct = new int[n + 1];
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (v.indexOf(c) != -1) {
				ct[i + 1] = ct[i] + 1;
			}
		}
		int ans = 0;
		for (int i = k; i <= ct.length; i++) {
			ans = Math.max(ans, ct[i] - ct[i - k]);
		}
		return ans;
	}
}
