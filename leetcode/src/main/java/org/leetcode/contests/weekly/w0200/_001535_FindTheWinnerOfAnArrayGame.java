package org.leetcode.contests.weekly.w0200;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001535_FindTheWinnerOfAnArrayGame {
	public int getWinner(int[] arr, int k) {
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();
		int curMax = arr[0];
		for (int i = 1; i < n; i++) {
			curMax = Math.max(curMax, arr[i]);
			map.put(curMax, 1 + map.getOrDefault(curMax, 0));
			if (map.get(curMax) == k)  return curMax;
		}
		return curMax;
	}
}
