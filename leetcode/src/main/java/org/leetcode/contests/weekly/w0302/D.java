package org.leetcode.contests.weekly.w0302;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public int minOperations(int[] nums, int[] numsDivide) {
		int nn = nums.length;
		if (Arrays.stream(nums).anyMatch(x -> x == 1))
			return 0;
		long gcd = numsDivide[0];
		for (int num : numsDivide) {
			gcd = gcd(gcd, num);
		}
		Arrays.sort(nums);
		for (int i = 0; i < nn; i++) {
			if (gcd % nums[i] == 0) {
				return i;
			}
		}
		return -1;
	}

	static long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}
