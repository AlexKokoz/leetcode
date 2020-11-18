package org.leetcode.contests.weekly.w0213;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001640_CheckArrayFormationThroughConcatenation {
	public boolean canFormArray(int[] arr, int[][] pieces) {
		int n = arr.length;
		Map<Integer, int[]> map = new HashMap<>();
		for (int[] piece : pieces)
			map.put(piece[0], piece);
		for (int i = 0; i < n;) {
			int[] piece = map.get(arr[i]);
			if (piece == null)
				return false;
			int j = 0;
			while (i < n && j < piece.length && arr[i] == piece[j]) {
				i++;
				j++;
			}
			if (j != piece.length)
				return false;
		}
		return true;
	}
}
