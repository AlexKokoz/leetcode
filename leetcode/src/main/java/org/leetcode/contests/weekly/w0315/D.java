package org.leetcode.contests.weekly.w0315;

import java.util.TreeSet;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public long countSubarrays(int[] nums, int minK, int maxK) {
		if (minK > maxK)
			return 0;
		int n = nums.length;
		long ans = 0;

		for (int i = 0; i < n;) {
			if (nums[i] < minK || nums[i] > maxK) {
				i++;
				continue;
			}
			int j = i;
			while (j < n && nums[j] >= minK && nums[j] <= maxK) {
				j++;
			}
			TreeSet<Integer> mins = new TreeSet<>();
			TreeSet<Integer> maxs = new TreeSet<>();
			for (int m = i; m < j; m++) {

				if (nums[m] == minK)
					mins.add(m);
				if (nums[m] == maxK)
					maxs.add(m);

				Integer minPos = mins.floor(m);
				if (minPos == null)
					continue;
				Integer maxPos = maxs.floor(m);
				if (maxPos == null)
					continue;

				int pos = Math.min(minPos, maxPos);
				ans += pos - i + 1;

			}

			i = j;
		}

		return ans;
	}
}
