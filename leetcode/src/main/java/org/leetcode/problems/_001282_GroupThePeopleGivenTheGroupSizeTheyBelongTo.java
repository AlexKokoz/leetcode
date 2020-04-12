package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001282_GroupThePeopleGivenTheGroupSizeTheyBelongTo {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		final List<List<Integer>> ans = new LinkedList<>();
		final int n = groupSizes.length;
		@SuppressWarnings("unchecked")
		final List<Integer>[] groups = new List[n + 1];
		for (int i = 0; i < n; i++) {
			final int sz = groupSizes[i];
			if (groups[sz] == null) {
				groups[sz] = new LinkedList<>();
			} else if (groups[sz].size() == sz) {
				ans.add(groups[sz]);
				groups[sz] = new LinkedList<>();
			}
			groups[sz].add(i);
		}
		for (List<Integer> group : groups) {
			if (group != null && group.size() > 0) {
				ans.add(group);
			}
		}
		return ans;
	}
}
