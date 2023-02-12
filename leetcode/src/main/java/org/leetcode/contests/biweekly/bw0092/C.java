package org.leetcode.contests.biweekly.bw0092;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int bestClosingTime(String customers) {
		int n = customers.length();
		int ans = n;
		int penalty = Integer.MAX_VALUE;
		int[] lr = new int[n + 2];
		for (int i = 0; i < n; i++) {
			lr[i + 1] = lr[i] + (customers.charAt(i) == 'N' ? 1 : 0);
		}
		lr[n + 1] = lr[n];
		int[] rl = new int[n + 2];
		for (int i = n - 1; i >= 0; i--) {
			rl[i] = rl[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
		}
		for (int i = 0; i <= n; i++) {
			int cand = lr[i] + rl[i];
			if (cand < penalty) {
				ans = i;
				penalty = cand;
			}
		}
		return ans;
	}
}
