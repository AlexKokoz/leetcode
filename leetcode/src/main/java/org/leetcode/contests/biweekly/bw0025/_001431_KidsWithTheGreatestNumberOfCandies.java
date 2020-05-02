package org.leetcode.contests.biweekly.bw0025;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001431_KidsWithTheGreatestNumberOfCandies {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> ans = new LinkedList<>();
		int max = 0;
		for (int c : candies)
			max = Math.max(max, c);
		for (int c : candies)
			if (c + extraCandies >= max)
				ans.add(true);
			else
				ans.add(false);
		return ans;
	}
}
