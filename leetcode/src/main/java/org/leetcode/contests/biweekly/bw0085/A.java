package org.leetcode.contests.biweekly.bw0085;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int minimumRecolors(String blocks, int k) {
		int ans = k;
		int whites = 0;
		int n = blocks.length();
		for (int i = 0; i < k - 1; i++) {
			if (blocks.charAt(i) == 'W')
				whites++;
		}
		for (int i = k - 1; i < n; i++) {
			if (blocks.charAt(i) == 'W')
				whites++;
			ans = Math.min(ans, whites);
			if (blocks.charAt(i - k + 1) == 'W')
				whites--;
		}
		return ans;
	}
}
