package org.leetcode.contests.biweekly.bw0071;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long minimumDifference(int[] nums) {
		int n3 = nums.length;
		int n = n3 / 3;
		long[] left = new long[n3];
		Arrays.fill(left, Long.MAX_VALUE);
		PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		long minSum = 0;
		for (int i = 0; i < n * 2; i++) {
			minSum += nums[i];
			max.add(nums[i]);
			if (max.size() > n)
				minSum -= max.poll();
			if (i >= n - 1) {
				left[i] = minSum;
				if (i - 1 >= 0 && left[i - 1] != Long.MAX_VALUE)
					left[i] = Math.min(left[i], left[i - 1]);
			}
		}

		long ans = Long.MAX_VALUE;
		long maxSum = 0;
		long right = Long.MIN_VALUE;
		PriorityQueue<Integer> min = new PriorityQueue<>();
		for (int i = n3 - 1; i >= n; i--) {
			maxSum += nums[i];
			min.add(nums[i]);
			if (min.size() > n)
				maxSum -= min.poll();
			if (min.size() == n) {
				right = Math.max(right, maxSum);
				ans = Math.min(ans, left[i - 1] - right);
			}
		}
		return ans;
	}
}
