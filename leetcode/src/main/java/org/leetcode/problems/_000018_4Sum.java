package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new LinkedList<>();
		int n = nums.length;

		Arrays.sort(nums);
		for (int i = 0; i <= n - 4; i++) {
			if (nums[i] > 0 && nums[i] > target)
				break;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j <= n - 3; j++) {
				if (nums[j] > 0 && nums[i] + nums[j] > target)
					break;
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int target2Sum = target - nums[i] - nums[j];
				int lo = j + 1;
				int hi = n - 1;
				while (lo < hi) {
					int cur2Sum = nums[lo] + nums[hi];
					if (cur2Sum == target2Sum) {
						ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi - 1] == nums[hi])
							hi--;
						lo++;
						hi--;
					} else if (cur2Sum < target2Sum) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return ans;
	}
}
