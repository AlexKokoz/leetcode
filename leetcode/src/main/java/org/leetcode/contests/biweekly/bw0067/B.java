package org.leetcode.contests.biweekly.bw0067;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public List<Integer> goodDaysToRobBank(int[] security, int time) {
		int n = security.length;
		List<Integer> ans = new ArrayList<>();
		int[] lr = new int[n];
		lr[0] = 1;
		for (int i = 1; i < n; i++) {
			if (security[i - 1] >= security[i])
				lr[i] = lr[i - 1] + 1;
			else
				lr[i] = 1;
		}
		int[] rl = new int[n];
		rl[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (security[i + 1] >= security[i])
				rl[i] = rl[i + 1] + 1;
			else
				rl[i] = 1;
		}
		for (int i = time; i < n - time; i++) {
			if (time == 0) {
				ans.add(i);
			} else {
				if (lr[i - 1] >= time && rl[i + 1] >= time && security[i - 1] >= security[i]
						&& security[i] <= security[i + 1]) {
					ans.add(i);
				}
			}
		}
		return ans;
	}
}
