package org.leetcode.contests.biweekly.bw0029;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001492_TheKthFactorΟfΝ {
	public int kthFactor(int n, int k) {
		int sq = (int) Math.sqrt(n);
		List<Integer> list1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		for (int i = 1, j = 0; i <= sq; i++) {
			if (n % i == 0) {
				j++;
				list1.add(i);
				int mirror = n / i;
				if (mirror != i) list2.add(mirror);
				if (j == k) return i;
			}
		}
		if (k <= list1.size() + list2.size()) return list2.get(list2.size() - k - list1.size());
		return -1;
	}
}
