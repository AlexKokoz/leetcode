package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001465_MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		int mod = 1000000007;
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		long maxh = horizontalCuts[0];
		for (int i = 1; i < horizontalCuts.length; i++) {
			maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i - 1]);
		}
		maxh = Math.max(maxh, h - horizontalCuts[horizontalCuts.length - 1]);
		maxh %= mod;

		long maxv = verticalCuts[0];
		for (int i = 1; i < verticalCuts.length; i++) {
			maxv = Math.max(maxv, verticalCuts[i] - verticalCuts[i - 1]);
		}
		maxv = Math.max(maxv, w - verticalCuts[verticalCuts.length - 1]);
		maxv %= mod;

		return (int) (maxh * maxv % mod);
	}
}
