package org.leetcode.contests.biweekly.bw0038;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
	public int maxWidthOfVerticalArea(int[][] points) {
		Set<Integer> xset = new HashSet<>();
		for (int[] p : points)
			xset.add(p[0]);
		int[] xs = new int[xset.size()];
		int p = 0;
		for (int x : xset)
			xs[p++] = x;
		Arrays.sort(xs);
		int ans = 0;
		for (int i = 1; i < xs.length; i++)
			ans = Math.max(ans, xs[i] - xs[i - 1]);
		return ans;
	}

}
