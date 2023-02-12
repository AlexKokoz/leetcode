package org.leetcode.contests.weekly.w0273;

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
	public long[] getDistances(int[] arr) {
		int n = arr.length;
		long[] ans = new long[n];
		Map<Integer, Integer> count = new HashMap<>();
		Map<Integer, Integer> last = new HashMap<>();
		Map<Integer, Long> lastSum = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (last.containsKey(arr[i])) {
				long add = (long) count.get(arr[i]) * (i - last.get(arr[i]))
						+ lastSum.getOrDefault(arr[i], 0L);
				ans[i] += add;
				lastSum.put(arr[i], add);
			}
			last.put(arr[i], i);
			count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
		}
		count = new HashMap<>();
		last = new HashMap<>();
		lastSum = new HashMap<>();
		for (int i = n - 1; i >= 0; i--) {
			if (last.containsKey(arr[i])) {
				long add = (long) count.get(arr[i]) * (last.get(arr[i]) - i)
						+ lastSum.getOrDefault(arr[i], 0L);
				ans[i] += add;
				lastSum.put(arr[i], add);
			}
			last.put(arr[i], i);
			count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
		}
		return ans;
	}
}
