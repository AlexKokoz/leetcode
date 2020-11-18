package org.leetcode.contests.weekly.w0211;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001625_LexicographicallySmallestStringAfterApplyingOperations {

	public String findLexSmallestString(String s, int a, int b) {
		int n = s.length();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = s.charAt(i) - '0';
		int[] min = Arrays.copyOf(nums, n);
		;

		// even b; numbers will stay at positions with same parity as originally
		if (b % 2 == 0) {

			for (int i = 0; i < 10; i++) {
				for (int j = 1; j < n; j += 2) {
					nums[j] += a;
					if (nums[j] > 9)
						nums[j] -= 10;
				}
				boolean[] seen = new boolean[n];
				for (int start = 0; ; start+=b) {
					if (start >= n) start -=n;
					if (seen[start]) break;
					if (less(nums, start, min, 0, n))
						min = buildFrom(nums, start);
					seen[start] = true;
				}
			}
		}
		// odd b; must check every substring of every even change with every substring
		// of every odd change
		else {
			int[] even = Arrays.copyOf(nums, n);
			for (int i = 0; i < 10; i++) {
				even = update(even, a, false);
				int[] evenodd = Arrays.copyOf(even, n);
				for (int j = 0; j < 10; j++) {
					evenodd = update(evenodd, a, true);
					boolean[] seen = new boolean[n];
					for (int start = 0; ; start+=b) {
						if (start >= n) start -=n;
						if (seen[start]) break;
						if (less(evenodd, start, min, 0, n))
							min = buildFrom(evenodd, start);
						seen[start] = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int num : min)
			sb.append(num);
		return sb.toString();
	}

	boolean less(int[] a1, int i1, int[] a2, int i2, int len) {
		assert a1.length == a2.length && a1.length == len;
		for (int i = 0; i < len; i++) {
			if (a1[i1] > a2[i2])
				return false;
			if (a1[i1] < a2[i2])
				return true;
			i1++;
			if (i1 == len)
				i1 = 0;
			i2++;
			if (i2 == len)
				i2 = 0;
		}
		return false;
	}

	int[] buildFrom(int[] nums, int start) {
		int n = nums.length;
		assert start >= 0 && start < n;
		int[] ret = new int[n];
		for (int i = 0; i < n; i++) {
			ret[i] = nums[start];
			start++;
			if (start == n)
				start = 0;
		}
		return ret;
	}

	int[] update(int[] nums, int v, boolean odd) {
		int[] ret = Arrays.copyOf(nums, nums.length);
		for (int i = (odd) ? 1 : 0; i < nums.length; i += 2) {
			ret[i] += v;
			if (ret[i] > 9)
				ret[i] -= 10;
		}
		return ret;
	}
}
