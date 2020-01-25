package org.leetcode.contests.biweekly.bw0018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001331_RankTransformOfAnArray {
	
	public int[] arrayRankTransform(int[] arr) {
		int n = arr.length;
		if (n == 0) return arr;
		int[] cp = Arrays.copyOf(arr, n);
		Arrays.sort(cp);
		int rank = 1;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(cp[0], 1);
		for (int i = 1; i < n; i++)  {
			if (cp[i] != cp[i - 1]) {
				rank++;
				map.put(cp[i], rank);
			}
		}
		for (int i = 0; i < n; i++) {
			cp[i] = map.get(arr[i]);
		}
		return cp;
	}
	
	
	/*
	 
	 --- 2nd Solution ---
	 
	public int[] arrayRankTransform(int[] arr) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int x : arr)
			map.put(x, 0);
		int rank = 1;
		for (int key : map.keySet())
			map.put(key, rank++);
		for (int i = 0; i < arr.length; i++)
			arr[i] = map.get(arr[i]);
		return arr;
	}
	
	*/
}
