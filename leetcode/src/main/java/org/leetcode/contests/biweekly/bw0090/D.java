package org.leetcode.contests.biweekly.bw0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] secondGreaterElement(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		Arrays.fill(ans, -1);

		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] right = new int[n];
		right[n - 1] = n;
		for (int i = n - 2; i >= 0; i--) {
			int next = i + 1;
			while (next != n && nums[i] >= nums[next]) {
				next = right[next];
			}
			right[i] = next;
			if (right[i] != n) {
				map.computeIfAbsent(right[i], z -> new ArrayList<>()).add(i);
			}
		}
		int[] dq = new int[n];
		int front = n - 1;
		int tail = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int pos : map.getOrDefault(i, new ArrayList<>())) {
				int lo = tail + 1;
				int hi = front;
				int found = n;
				while (lo <= hi) {
					int mi = lo + (hi - lo) / 2;
					if (dq[mi] > nums[pos]) {
						found = mi;
						hi = mi - 1;
					} else {
						lo = mi + 1;
					}
				}

				ans[pos] = found == n ? -1 : dq[found];
			}

			// update deque
			while (tail + 1 <= front && nums[i] > dq[tail + 1]) {
				tail++;
			}
			dq[tail--] = nums[i];
		}
		return ans;
	}
}
