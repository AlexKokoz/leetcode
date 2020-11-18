package org.leetcode.contests.biweekly.bw0039;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001652_DefuseTheBomb {
	public int[] decrypt(int[] code, int k) {
		int n = code.length;
		int[] ans = new int[n];
		if (k == 0)
			return ans;
		for (int i = 0; i < n; i++) {
			if (k < 0) {
				int j = i == 0 ? n - 1 : i - 1;
				for (int kk = -k; kk > 0; kk--) {
					ans[i] += code[j];
					j--;
					if (j < 0)
						j = n - 1;
				}
			} else if (k > 0) {
				int j = i == n - 1 ? 0 : i + 1;
				for (int kk = k; kk > 0; kk--) {
					ans[i] += code[j];
					j++;
					if (j == n)
						j = 0;
				}
			}
		}
		return ans;
	}
}
