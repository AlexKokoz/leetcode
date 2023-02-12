package org.leetcode.contests.weekly.w0273;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] recoverArray(int[] nums) {
		int n2 = nums.length;
		int n = n2 / 2;
		int[] ans = new int[n];
		Arrays.sort(nums);
		Set<Integer> cands1 = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			int cand = nums[i] - nums[0];
			if (cand > 0 && (cand & 1) == 0) {
				cands1.add(cand);
			}
		}
		Set<Integer> cands2 = new HashSet<>();
		for (int i = n2 - n - 1; i < n2 - 1; i++) {
			int cand = nums[n2 - 1] - nums[i];
			if (cand > 0 && (cand & 1) == 0 && cands1.contains(cand)) {
				cands2.add(cand);
			}
		}
		outer: for (int cand : cands2) {
			Deque<Integer> dq = new ArrayDeque<>();
			int p = 0;
			int k = cand / 2;
			for (int num : nums) {
				if (!dq.isEmpty() && num == dq.peekFirst()) {
					dq.pollFirst();
					continue;
				} else {
					if (p == n)
						continue outer;
					ans[p++] = num + k;
					dq.addLast(num + cand);
				}

			}
			if (p == n)
				break;
		}
		return ans;
	}
}
