package org.leetcode.contests.biweekly.bw0039;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001653_MinimumDeletionsToMakeStringBalanced {
	public int minimumDeletions(String s) {
		int n = s.length();
		int ans = n;
		int[] as = new int[n + 1];
		int[] bs = new int[n + 1];

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			as[i + 1] = as[i] + (c == 'a' ? 1 : 0);
			bs[i + 1] = bs[i] + (c == 'b' ? 1 : 0);
		}
		for (int i = 0; i < n; i++) {
			int preb = bs[i];
			int sufa = as[n] - as[i + 1];
			ans = Math.min(ans, preb + sufa);
		}
		return ans;
	}

}
