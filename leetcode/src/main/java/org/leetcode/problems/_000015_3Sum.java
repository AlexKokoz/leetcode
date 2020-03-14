package org.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
public class _000015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		int n = nums.length;

		Arrays.sort(nums);
		for (int i = 0; i <= n - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int target = -nums[i];
			Set<Integer> marked = new HashSet<>();
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = i + 1; j < n; j++) {
				if (marked.contains(nums[j]))
					continue;
				int complement = target - nums[j];
				Integer pos = map.get(nums[j]);
				if (pos != null) {
					ans.add(Arrays.asList(nums[i], nums[pos], nums[j]));
					marked.add(nums[j]);
					marked.add(complement);
				} else {
					map.put(complement, j);
				}
			}
		}
		return ans;
	}
}
