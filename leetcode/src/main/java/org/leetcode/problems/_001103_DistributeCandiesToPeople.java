package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001103_DistributeCandiesToPeople {
	public int[] distributeCandies(int candies, int n) {
		int[] ans = new int[n];
		int i = 0;
		int counter = 1;
		while (candies > 0) {
			int chunk = Math.min(candies, counter);
			ans[i] += chunk;
			candies -= chunk;
			i++;
			counter++;
			if (i == n)
				i = 0;
		}
		return ans;
	}
}
