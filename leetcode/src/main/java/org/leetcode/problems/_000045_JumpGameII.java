package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000045_JumpGameII {
	public int jump(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return 0;
		boolean[] passed = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		int steps = 0;
		passed[0] = true;
		while (!q.isEmpty()) {
			steps++;
			for (int i = 0, size = q.size(); i < size; i++) {
				int cur = q.poll();
				for (int step = 1; step <= nums[cur]; step++) {
					int frontMove = cur + step;
					if (frontMove == n - 1)
						return steps;
					else if (frontMove < n && !passed[frontMove]) {
						passed[frontMove] = true;
						q.add(frontMove);
					}
				}
			}
		}
		return 0;
	}
}
