package org.leetcode.contests.weekly.w0290;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public List<Integer> intersection(int[][] nums) {
		List<Integer> ans = new ArrayList<>();
		int[] count = new int[1001];
		int n = nums.length;
		for (int[] row : nums) {
			Set<Integer> set = new HashSet<>();
			for (int x : row)
				set.add(x);
			for (int x : set)
				count[x]++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] == n)
				ans.add(i);
		}
		return ans;
	}
}
