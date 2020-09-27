package org.leetcode.contests.biweekly.bw0035;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001590_MakeSumDivisibleByP {
	public int minSubarray(int[] nums, int p) {
		int n = nums.length;
		long sum = 0;
		int ans = n;

		long[] pre = new long[n + 1];
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			pre[i + 1] = sum % p;
		}

		sum = 0;
		long[] suf = new long[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			sum += nums[i];
			suf[i] = sum % p;
		}

		Map<Long, TreeSet<Integer>> map = new HashMap<>();
		for (int i = n; i >= 0; i--) {
			TreeSet<Integer> set = map.getOrDefault(suf[i], new TreeSet<>());
			set.add(i);
			map.put(suf[i], set);

		}

		for (int i = 0; i <= n; i++) {
			long search = p - (int) pre[i];
			TreeSet<Integer> set = map.get(search);
			if (set != null) {
				Integer ceil = set.ceiling(i);
				if (ceil != null) {
					ans = Math.min(ans, ceil - i);
				}
			}
			if (pre[i] == 0) {
				set = map.get(0L);
				if (set != null) {
					Integer ceil = set.ceiling(i);
					if (ceil != null) {
						ans = Math.min(ans, ceil - i);
					}
				}
			}
		}

		return ans == n ? -1 : ans;
	}
}
