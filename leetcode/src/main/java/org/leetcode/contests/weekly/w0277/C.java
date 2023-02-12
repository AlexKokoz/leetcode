package org.leetcode.contests.weekly.w0277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public List<Integer> findLonely(int[] nums) {
		Set<Integer> ans = new HashSet<>();
		Map<Integer, Integer> count = new HashMap<>();
		for (int num : nums)
			count.put(num, count.getOrDefault(num, 0) + 1);
		for (int num : nums) {
			if (count.get(num) == 1 && count.getOrDefault(num - 1, 0) == 0
					&& count.getOrDefault(num + 1, 0) == 0)
				ans.add(num);
		}
		return new ArrayList<>(ans);
	}
}
