package org.leetcode.contests.weekly.w0283;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public List<Integer> replaceNonCoprimes(int[] nums) {

		int n = nums.length;
		TreeSet<Integer> poss = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			poss.add(i);
		}
		boolean[] deleted = new boolean[n];

		Deque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < n - 1; i++) {
			int gcd = gcd(nums[i], nums[i + 1]);
			if (gcd > 1) {
				dq.add(new int[] { i, i + 1 });
			}
		}

		while (!dq.isEmpty()) {
			int node[] = dq.pollFirst(), i = node[0], j = node[1];
			if (deleted[i] || deleted[j])
				continue;
			nums[i] = (int) ((long) nums[i] * nums[j] / gcd(nums[i], nums[j]));
			deleted[j] = true;
			poss.remove(j);

			// check for ceiling
			Integer h = poss.higher(i);
			if (h != null) {
				int gcd = gcd(nums[i], nums[h]);
				if (gcd > 1) {
					dq.addFirst(new int[] { i, h });
					continue;
				}
			}

			// check for floor
			Integer l = poss.lower(i);
			if (l != null) {
				int gcd = gcd(nums[i], nums[l]);
				if (gcd > 1) {
					dq.addFirst(new int[] { l, i });
					continue;
				}
			}
		}

		List<Integer> ans = new ArrayList<>();
		for (int pos : poss) {
			ans.add(nums[pos]);
		}
		return ans;
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int mod = a % b;
			a = b;
			b = mod;
		}
		return a;
	}
}
