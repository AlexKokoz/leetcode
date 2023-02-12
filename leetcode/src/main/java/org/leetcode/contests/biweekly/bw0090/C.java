package org.leetcode.contests.biweekly.bw0090;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int destroyTargets(int[] nums, int space) {
		int max = 0;
		int ans = Integer.MAX_VALUE;
		Arrays.sort(nums);
		Map<Integer, Integer> counts = new HashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int mod = num % space;
			if (map.containsKey(mod)) {
				counts.put(mod, counts.get(mod) + 1);
			} else {
				counts.put(mod, 1);
				map.put(mod, num);
			}
		}
		for (int key : counts.keySet()) {
			int count = counts.get(key);
			int cand = map.get(key);
			if (count > max || (count == max && cand < ans)) {
				max = count;
				ans = cand;
			}
		}
		return ans;
	}
}
