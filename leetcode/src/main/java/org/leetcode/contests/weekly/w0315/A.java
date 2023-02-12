package org.leetcode.contests.weekly.w0315;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int findMaxK(int[] nums) {
		Boolean[] ok = new Boolean[1001];
		int ans = -1;
		for (int num : nums) {
			if (num > 0) {
				if (ok[num] != null) {
					if (!ok[num]) {
						ans = Math.max(ans, num);
					}
				} else {
					ok[num] = true;
				}
			} else {
				num = -num;
				if (ok[num] != null) {
					if (ok[num]) {
						ans = Math.max(ans, num);
					}
				} else {
					ok[num] = false;
				}
			}
		}
		return ans;
	}
}
