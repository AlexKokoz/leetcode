package org.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001560_MostVisitedSectorInACircularTrack {
	public List<Integer> mostVisited(int n, int[] rounds) {
		List<Integer> list = new ArrayList<>();
		int m = rounds.length;
		if (m == 1) {
			list.add(rounds[0]);
		} else if (rounds[0] == rounds[m - 1]) {
			list.add(rounds[0]);
		} else if (rounds[0] < rounds[m - 1]) {
			for (int i = rounds[0]; i <= rounds[m - 1]; i++)
				list.add(i);
		} else {
			for (int i = rounds[0]; i <= n; i++)
				list.add(i);
			for (int i = 1; i <= rounds[m - 1]; i++)
				list.add(i);
		}
		Collections.sort(list);
		return list;
	}
}
