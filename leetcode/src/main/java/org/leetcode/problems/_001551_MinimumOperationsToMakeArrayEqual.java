package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001551_MinimumOperationsToMakeArrayEqual {
	public int minOperations(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int num = (i << 1) + 1;
			sum += num;
		}
		int limit = sum / n;
		int ans = 0;
		for (int i = 0; i <= n / 2; i++)
			ans += Math.abs(limit - (2 * i + 1));
		return ans;

	}
}
