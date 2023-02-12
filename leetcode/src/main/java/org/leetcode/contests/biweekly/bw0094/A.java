package org.leetcode.contests.biweekly.bw0094;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int captureForts(int[] forts) {
		int n = forts.length;
		int ans = 0;
		for (int i = 0; i < n;) {
			if (forts[i] == 0) {
				i++;
			} else if (forts[i] == -1) {
				int j = i + 1;
				while (j < n && forts[j] == 0) {
					j++;
				}
				if (j < n && forts[j] == 1) {
					ans = Math.max(ans, j - i - 1);
				}
				i = j;
			} else {
				int j = i + 1;
				while (j < n && forts[j] == 0) {
					j++;
				}
				if (j < n && forts[j] == -1) {
					ans = Math.max(ans, j - i - 1);
				}
				i = j;
			}
		}
		return ans;
	}
}
