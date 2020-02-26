package org.leetcode.problems;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001362_ClosestDivisors {
	int[] ans;
	int minDiff;

	public int[] closestDivisors(int num) {
		ans = new int[2];
		minDiff = Integer.MAX_VALUE;
		check(num + 1);
		check(num + 2);
		return ans;
	}

	void check(int num) {
		int sqrt = (int) Math.sqrt(num);
		for (int i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				int j = num / i;
				int diff = Math.abs(i - j);
				if (diff < minDiff) {
					minDiff = diff;
					ans[0] = i;
					ans[1] = j;
				}
			}
		}
	}
}
