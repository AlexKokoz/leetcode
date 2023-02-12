package org.leetcode.contests.weekly.w0286;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long[] kthPalindrome(int[] queries, int intLength) {
		int nq = queries.length;
		int h = (intLength + 1) / 2;
		int possible = 9 * (int) Math.pow(10, h - 1);
		long[] ans = new long[nq];
		int[] p10s = new int[h + 1];
		p10s[h] = 1;
		for (int i = h - 1; i > 0; i--) {
			p10s[i] = p10s[i + 1] * 10;
		}
		p10s[0] = 9 * p10s[1];
		for (int i = 0; i < nq; i++) {
			ans[i] = queries[i] > possible ? -1 : get(queries[i], intLength, h, p10s);
		}
		return ans;

	}

	long get(int query, int len, int h, int[] p10s) {
		long ans = 0;
		long front = 0, back = 0, p10 = 1;
		for (int i = 0; i < h; i++) {
			int d = (i == 0 ? 1 : 0);
			while (d < 9 && p10s[i + 1] < query) {
				query -= p10s[i + 1];
				d++;
			}
			front = front * 10 + d;
			back = d * p10 + back;
			p10 *= 10;
		}
		if (len % 2 == 0) {
			ans = front * p10 + back;
		} else {
			ans = front * (p10 / 10) + back % (p10 / 10);
		}
		return ans;
	}
}
