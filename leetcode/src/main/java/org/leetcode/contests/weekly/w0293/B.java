package org.leetcode.contests.weekly.w0293;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int maxConsecutive(int bottom, int top, int[] special) {
		Arrays.sort(special);
		int ans = 0;
		int prev = bottom - 1;
		for (int floor : special) {
			ans = Math.max(ans, floor - prev - 1);
			prev = floor;
		}
		ans = Math.max(ans, top - prev);
		return ans;
	}
}
