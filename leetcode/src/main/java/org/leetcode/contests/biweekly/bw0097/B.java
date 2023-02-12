package org.leetcode.contests.biweekly.bw0097;

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
	public int maxCount(int[] banned, int n, int maxSum) {
		Set<Integer> bads = new HashSet<>();
		for (int num : banned)
			bads.add(num);
		int ans = 0;
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (sum + i > maxSum)
				break;
			if (bads.contains(i))
				continue;
			sum += i;
			ans++;
		}
		return ans;
	}
}
