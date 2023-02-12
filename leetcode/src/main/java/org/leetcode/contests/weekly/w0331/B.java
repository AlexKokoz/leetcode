package org.leetcode.contests.weekly.w0331;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[] vowelStrings(String[] words, int[][] queries) {
		int nw = words.length;
		int nq = queries.length;
		int[] ans = new int[nq];
		int[] acc = new int[nw + 1];
		String vowels = "aeiou";
		for (int i = 0; i < nw; i++) {
			int n = words[i].length();
			if (vowels.indexOf(words[i].charAt(0)) != -1 && vowels.indexOf(words[i].charAt(n - 1)) != -1) {
				acc[i + 1]++;
			}
		}
		for (int i = 1; i < acc.length; i++) {
			acc[i] += acc[i - 1];
		}
		for (int i = 0; i < nq; i++) {
			ans[i] = acc[queries[i][1] + 1] - acc[queries[i][0]];
		}
		return ans;
	}
}
