package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001566_DetectPatternOfLengthMRepeatedKorMoreTimes {
	public boolean containsPattern(int[] arr, int m, int k) {
		int n = arr.length;
		outer: for (int i = 0; i <= n - k * m; i++) {
			int counter = 1;
			for (int kk = 1; kk < k; kk++) {
				for (int j = i + kk * m; j <= n - m; j++) {
					if (eq(arr, i, j, m))
						counter++;
					else
						continue outer;
					if (counter >= k)
						return true;
				}
			}
		}
		return false;
	}

	boolean eq(int[] a, int s1, int s2, int len) {
		for (int i = 0; i < len; i++) {
			if (a[s1 + i] != a[s2 + i])
				return false;
		}
		return true;
	}
}
