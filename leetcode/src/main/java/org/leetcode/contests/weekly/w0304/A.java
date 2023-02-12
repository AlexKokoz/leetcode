package org.leetcode.contests.weekly.w0304;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	
	/*
	// Time: O(NlogN), Space: O(1) 
	public int minimumOperations(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int ans = 0;
		for (int r = 0; r < n;) {
			if (nums[r] == 0) {
				r++;
				continue;
			}
			int l = r;
			while (r < n && nums[r] == nums[l])
				r++;
			ans++;
		}
		return ans;
	}
	*/
	// Time: O(N), Space: O(N) 
	public int minimumOperations(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		return set.size() - (set.contains(0) ?  1 : 0);
	}
}
