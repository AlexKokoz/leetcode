package org.leetcode.contests.biweekly.bw0014;

import java.util.LinkedList;
import java.util.List;

/**
 * MEDIUM
 * 
 * @author AccelSprinter
 *
 */
public class _001272_RemoveInterval {

	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		final List<List<Integer>> ans = new LinkedList<>();
		for (int[] interval : intervals) {
			final List<Integer> temp = new LinkedList<>();
			final List<Integer> temp2 = new LinkedList<>();
			if (interval[0] <= toBeRemoved[0] && toBeRemoved[1] <= interval[1]) {
				temp.add(interval[0]);
				temp.add(toBeRemoved[0]);
				temp2.add(toBeRemoved[1]);
				temp2.add(interval[1]);

			} else if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
				temp.add(interval[0]);
				temp.add(interval[1]);
			} else if (interval[0] < toBeRemoved[1] && toBeRemoved[1] <= interval[1]) {
				temp.add(toBeRemoved[1]);
				temp.add(interval[1]);
			} else if (interval[0] <= toBeRemoved[0] && toBeRemoved[0] < interval[1]) {
				temp.add(interval[0]);
				temp.add(toBeRemoved[0]);
			}

			if (!temp.isEmpty() && temp.get(0) != temp.get(1))
				ans.add(temp);
			if (!temp2.isEmpty() && temp2.get(0) != temp2.get(1))
				ans.add(temp2);

		}
		return ans;
	}
}
