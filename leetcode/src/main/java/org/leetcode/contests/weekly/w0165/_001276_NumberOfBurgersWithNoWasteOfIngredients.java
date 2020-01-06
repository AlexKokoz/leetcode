package org.leetcode.contests.weekly.w0165;

import java.util.ArrayList;
import java.util.List;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001276_NumberOfBurgersWithNoWasteOfIngredients {

	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		final int small = (4 * cheeseSlices - tomatoSlices) / 2;
		final int jumbo = (tomatoSlices - 2 * small) / 4;
		final List<Integer> ans = new ArrayList<>();
		if (small < 0 || jumbo < 0 || 2 * small + 4 * jumbo != tomatoSlices)
			return ans;
		ans.add(jumbo);
		ans.add(small);
		return ans;
	}
}
