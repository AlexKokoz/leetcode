package org.leetcode.problems;

import java.util.TreeMap;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000220_ContainsDuplicatesIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int dist, int diff) {
		if (dist == 0)
			return false;
		int n = nums.length;
		MultiSet multi = new MultiSet();
		for (int j = 1; j < n && j <= dist; j++)
			multi.add(nums[j]);
		for (int i = 0; i < n; i++) {
			// System.out.println(i + " " + multi.toString());
			Integer ceil = multi.ceiling(nums[i]);
			if (ceil != null && Math.abs((long) nums[i] - (long) ceil) <= (long) diff)
				return true;
			Integer floor = multi.floor(nums[i]);
			if (floor != null && Math.abs((long) nums[i] - (long) floor) <= (long) diff)
				return true;
			if (i + 1 < n)
				multi.remove(nums[i + 1]);
			multi.add(nums[i]);
			if (i + 1 + dist < n)
				multi.add(nums[i + 1 + dist]);
			if (i - dist >= 0)
				multi.remove(nums[i - dist]);
		}
		return false;
	}

	class MultiSet {
		TreeMap<Integer, Integer> map;

		public MultiSet() {
			map = new TreeMap<>();
		}

		public void add(int x) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		public void remove(int x) {
			Integer count = map.get(x);
			if (count == null)
				return;
			count--;
			if (count == 0)
				map.remove(x);
			else
				map.put(x, count);
		}

		public Integer ceiling(int x) {
			return map.ceilingKey(x);
		}

		public Integer floor(int x) {
			return map.floorKey(x);
		}

		public String toString() {
			return map.toString();
		}
	}
}
