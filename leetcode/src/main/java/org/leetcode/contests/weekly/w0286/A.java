package org.leetcode.contests.weekly.w0286;

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
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> ans = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Set<Integer> temp = new HashSet<>();
		for (int num : nums2)
			set.add(num);
		for (int num : nums1)
			if (!set.contains(num))
				temp.add(num);
		ans.add(new ArrayList<>(temp));
		set = new HashSet<>();
		temp = new HashSet<>();
		for (int num : nums1)
			set.add(num);
		for (int num : nums2)
			if (!set.contains(num))
				temp.add(num);
		ans.add(new ArrayList<>(temp));
		return ans;
	}
}
