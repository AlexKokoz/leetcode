package org.leetcode.contests.weekly.w0217;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _00162_RichestCustomerWealth {
	public int maximumWealth(int[][] accounts) {
		int max = 0;
		for (int[] row : accounts) {
			max = Math.max(max, Arrays.stream(row).parallel().sum());
		}
		return max;
	}
}
