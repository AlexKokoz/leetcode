package org.leetcode.contests.biweekly.bw0033;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001558_MinimumNumbersOfFunctionCallsYoMakeTargetArray {

	public int minOperations(int[] nums) {
		int max = 0;
		int ans = 0;
		for (int num : nums) {
			int ct = 0;
			while (num > 0) {
				if ((num & 1) == 0) {
					num >>= 1;
					ct++;
				} else {
					num--;
					ans++;
				}
			}
			max = Math.max(max, ct);
		}
		ans += max;
		return ans;
	}
}
