package org.leetcode.contests.biweekly.bw0080;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		int ns = spells.length;
		int np = potions.length;
		int[] ans = new int[ns];
		int[][] si = new int[ns][];
		for (int i = 0; i < ns; i++) {
			si[i] = new int[] { spells[i], i };
		}
		Arrays.sort(si, (a, b) -> Integer.compare(a[0], b[0]));

		int[][] pi = new int[np][];
		for (int i = 0; i < np; i++) {
			pi[i] = new int[] { potions[i], i };
		}
		Arrays.sort(pi, (a, b) -> Integer.compare(a[0], b[0]));

		int p = np - 1;
		for (int[] spell : si) {
			while (p >= 0 && (long) spell[0] * pi[p][0] >= success) {
				p--;
			}
			ans[spell[1]] = np - p - 1;
		}
		return ans;

	}
}
