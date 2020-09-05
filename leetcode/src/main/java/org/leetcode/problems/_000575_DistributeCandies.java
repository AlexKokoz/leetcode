package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000575_DistributeCandies {
	public int distributeCandies(int[] candies) {
		int n = candies.length;
		Set<Integer> set = new HashSet<>();
		for (int candie : candies)
			set.add(candie);
		return Math.min(n / 2, set.size());
	}
}
