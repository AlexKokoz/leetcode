package org.leetcode.contests.weekly.w0326;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] closestPrimes(int left, int right) {
		int[] ans = { -1, -1 };
		boolean[] np = new boolean[right + 1];
		int sqrt = (int) Math.sqrt(np.length);
		for (int i = 2; i <= sqrt; i++) {
			if (np[i])
				continue;
			for (int j = i + i; j < np.length; j += i) {
				np[j] = true;
			}
		}
		for (int i = Math.max(left, 2), prev = -1; i <= right; i++) {
			if (!np[i]) {
				if (prev != -1) {
					if (ans[0] == -1 || i - prev < ans[1] - ans[0]) {
						ans = new int[] { prev, i };
					}
				}
				prev = i;
			}
		}
		return ans;
	}
}
