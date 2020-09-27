package org.leetcode.contests.weekly.w0205;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001577_NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
	public int numTriplets(int[] nums1, int[] nums2) {
		Map<Long, Integer> sq1 = new HashMap<>();
		Map<Long, Integer> sq2 = new HashMap<>();
		for (long num : nums1) {
			long sq = num * num;
			sq1.put(sq, sq1.getOrDefault(sq, 0) + 1);
		}

		for (long num : nums2) {
			long sq = num * num;
			sq2.put(sq, sq2.getOrDefault(sq, 0) + 1);
		}

		int ans = 0;

		for (int i = 0; i < nums1.length - 1; i++) {
			for (int j = i + 1; j < nums1.length; j++) {
				long prod = (long) nums1[i] * nums1[j];
				Integer count = sq2.getOrDefault(prod, 0);
				if (count != null)
					ans += count;
			}
		}

		for (int i = 0; i < nums2.length - 1; i++) {
			for (int j = i + 1; j < nums2.length; j++) {
				long prod = (long) nums2[i] * nums2[j];
				Integer count = sq1.getOrDefault(prod, 0);
				if (count != null)
					ans += count;
			}
		}
		return ans;
	}

}
