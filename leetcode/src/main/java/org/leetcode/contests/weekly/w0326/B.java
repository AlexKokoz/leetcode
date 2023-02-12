package org.leetcode.contests.weekly.w0326;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int distinctPrimeFactors(int[] nums) {
		Set<Integer> ans = new HashSet<>();
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for (int num : nums) {
			set.add(num);
			max = Math.max(max, num);
		}
		boolean[] np = new boolean[max + 1];
		for (int i = 2; i <= max / 2; i++) {
			if (np[i])
				continue;
			for (int j = i; j <= max; j += i) {
				if (set.contains(j))
					ans.add(i);
				np[j] = true;
			}
		}
		for (int i = max / 2 + 1; i <= max; i++) {
			if (!np[i] && set.contains(i))
				ans.add(i);
		}
		return ans.size();
	}
}
