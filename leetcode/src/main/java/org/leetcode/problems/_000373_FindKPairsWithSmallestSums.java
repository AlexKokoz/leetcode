package org.leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000373_FindKPairsWithSmallestSums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		List<List<Integer>> ans = new LinkedList<>();
		Set<Long> seen = new HashSet<>();
		if (k == 0 || nums1.length == 0 || nums2.length == 0)
			return ans;
		int[] init = new int[] { nums1[0] + nums2[0], 0, 0 };
		pq.add(init);
		seen.add(hash(init));
		for (int i = 0; i < k && !pq.isEmpty(); i++) {
			int[] cur = pq.poll();
			int i1 = cur[1];
			int i2 = cur[2];
			List<Integer> pair = new LinkedList<>();
			pair.add(nums1[i1]);
			pair.add(nums2[i2]);
			ans.add(pair);
			if (i1 < nums1.length - 1) {
				int[] arr = new int[] { nums1[i1 + 1] + nums2[i2], i1 + 1, i2 };
				long hash = hash(arr);
				if (!seen.contains(hash)) {
					pq.add(arr);
					seen.add(hash);
				}
			}

			if (i2 < nums2.length - 1) {
				int[] arr = new int[] { nums1[i1] + nums2[i2 + 1], i1, i2 + 1 };
				long hash = hash(arr);
				if (!seen.contains(hash)) {
					pq.add(arr);
					seen.add(hash);
				}
			}
		}
		return ans;
	}

	long hash(int[] nums) {
		long h = 0;
		for (int num : nums)
			h = h * 1000000009 + num;
		return h;
	}
}
