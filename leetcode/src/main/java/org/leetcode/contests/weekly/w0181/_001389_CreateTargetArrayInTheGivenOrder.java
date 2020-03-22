package org.leetcode.contests.weekly.w0181;

import java.util.*;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001389_CreateTargetArrayInTheGivenOrder {
	public int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> list = new LinkedList<>();
		int n = nums.length;
		for (int i = 0;i < n; i++) {
			list.add(index[i], nums[i]);
		}
		int[] ans=  new int[n];
		for (int i = 0; i < n; i++)
			ans[i] = list.get(i);
		return ans;
	}
}
