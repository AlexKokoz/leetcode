package org.leetcode.contests.weekly.w0284;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> ans = new ArrayList<>();
		for (int j = 0, n = nums.length, prev = -1; j < n; j++) {
			if (nums[j] == key) {
				for (int cand = Math.max(prev + 1, Math.max(0, j - k)); cand <= Math.min(n - 1,
						j + k); cand++) {
					ans.add(cand);
					prev = cand;
				}
			}
		}
		return ans;
	}
}
