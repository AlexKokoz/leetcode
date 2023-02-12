package org.leetcode.contests.weekly.w0291;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int countDistinct(int[] nums, int k, int p) {
		Set<Long> set = new HashSet<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			long h = 0;
			int count = 0;
			for (int j = i; j < n; j++) {
				if (nums[j] % p == 0) {
					count++;
				}
				if (count > k)
					break;
				h = h * 1000000009 + nums[j];
				set.add(h);
			}
		}
		return set.size();
	}

}
