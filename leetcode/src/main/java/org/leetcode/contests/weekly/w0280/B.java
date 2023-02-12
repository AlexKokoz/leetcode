package org.leetcode.contests.weekly.w0280;

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
public class B {
	public int minimumOperations(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		if (n == 2)
			return nums[0] == nums[1] ? 1 : 0;
		int ans = n;
		int nEven = (n + 1) / 2;
		int nOdd = n - nEven;

		Map<Integer, Integer> evens = new HashMap<>(), odds = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				evens.put(nums[i], evens.getOrDefault(nums[i], 0) + 1);
			} else {
				odds.put(nums[i], odds.getOrDefault(nums[i], 0) + 1);
			}
		}

		int[][] evenCounter = new int[evens.size()][];
		{
			int p = 0;
			for (Map.Entry<Integer, Integer> entry : evens.entrySet()) {
				int val = entry.getKey(), count = entry.getValue();
				evenCounter[p++] = new int[] { val, count };
			}
		}
		Arrays.sort(evenCounter, (a, b) -> Integer.compare(a[1], b[1]));

		int[][] oddCounter = new int[odds.size()][];
		{
			int p = 0;
			for (Map.Entry<Integer, Integer> entry : odds.entrySet()) {
				int val = entry.getKey(), count = entry.getValue();
				oddCounter[p++] = new int[] { val, count };
			}
		}
		Arrays.sort(oddCounter, (a, b) -> Integer.compare(a[1], b[1]));
		if (evenCounter[evenCounter.length - 1][0] != oddCounter[oddCounter.length - 1][0]) {
			int cand = nEven - evenCounter[evenCounter.length - 1][1] + nOdd
					- oddCounter[oddCounter.length - 1][1];
			ans = Math.min(ans, cand);
		} else if (evenCounter.length == 1 && oddCounter.length == 1) {

			if (evenCounter[0][0] == oddCounter[0][0]) {
				ans = Math.min(ans, Math.min(evenCounter[0][1], oddCounter[0][1]));
			}
		} else {
			if (evenCounter.length > 1) {
				int cand = nEven - evenCounter[evenCounter.length - 2][1] + nOdd
						- oddCounter[oddCounter.length - 1][1];
				ans = Math.min(ans, cand);
			}

			if (oddCounter.length > 1) {
				int cand = nEven - evenCounter[evenCounter.length - 1][1] + nOdd
						- oddCounter[oddCounter.length - 2][1];
				ans = Math.min(ans, cand);
			}

		}
		return ans;
	}
}
