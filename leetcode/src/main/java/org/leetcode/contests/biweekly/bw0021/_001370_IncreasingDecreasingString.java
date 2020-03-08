package org.leetcode.contests.biweekly.bw0021;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001370_IncreasingDecreasingString {

	public String sortString(String s) {
		int n = s.length();
		int[] f = new int[26];
		for (int i = 0; i < n; i++)
			f[s.charAt(i) - 'a']++;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int i;
			for (i = 0; i < f.length; i++) {
				if (f[i] > 0) {
					sb.append((char) ('a' + i));
					f[i]--;
				}
			}
			if (sb.length() == n)
				break;
			for (i = f.length - 1; i >= 0; i--) {
				if (f[i] > 0) {
					sb.append((char) ('a' + i));
					f[i]--;
				}
			}
			if (sb.length() == n)
				break;
		}
		return sb.toString();
	}
}
