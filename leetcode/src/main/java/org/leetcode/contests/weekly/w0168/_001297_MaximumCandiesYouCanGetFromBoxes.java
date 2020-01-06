package org.leetcode.contests.weekly.w0168;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001297_MaximumCandiesYouCanGetFromBoxes {
	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		final int open = 1;
		final Queue<Integer> availBoxes = new LinkedList<>();
		final Set<Integer> availKeys = new HashSet<>();
		int ans = 0;
		for (int box : initialBoxes) {
			if (status[box] == open) {
				ans += candies[box];
				candies[box] = 0; // ?
				for (int contained : containedBoxes[box])
					availBoxes.add(contained);
				containedBoxes[box] = new int[0];
				for (int key : keys[box])
					availKeys.add(key);
				keys[box] = new int[0];
			} else
				availBoxes.add(box);
		}
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0, len = availBoxes.size(); i < len; i++) {
				final int box = availBoxes.poll();
				if (status[box] == open || availKeys.contains(box)) {
					ans += candies[box];
					candies[box] = 0;
					if (availKeys.contains(box))
						availKeys.remove(box);
					for (int contained : containedBoxes[box])
						availBoxes.add(contained);
					containedBoxes[box] = new int[0];
					for (int key : keys[box])
						availKeys.add(key);
					keys[box] = new int[0];
					changed = true;
				} else {
					availBoxes.add(box);
				}
			}
		}
		return ans;
	}
}
