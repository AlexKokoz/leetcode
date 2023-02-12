package org.leetcode.contests.weekly.w0220;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001696_JumpGameVI {
	public int maxResult(int[] nums, int k) {
		int n = nums.length;
		int[] memo = new int[n];
		Arrays.fill(memo, Integer.MIN_VALUE);
		memo[0] = nums[0];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		outer: while (!q.isEmpty()) {
			int cur = q.poll();
			for (int to = cur + 1; to <= Math.min(n - 1, cur + k); to++) {
				if (nums[to] >= 0) {
					memo[to] = memo[cur] + nums[to];
					q.add(to);
					continue outer;
				}
			}
			for (int to = Math.min(n - 1, cur + k); to > cur; to--) {
				if (memo[to] < memo[cur] + nums[to]) {
					memo[to] = memo[cur] + nums[to];
					q.add(to);
				}
			}
		}
		return memo[n - 1];
	}

}
