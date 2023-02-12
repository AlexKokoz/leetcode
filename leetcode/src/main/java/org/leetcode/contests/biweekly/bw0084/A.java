package org.leetcode.contests.biweekly.bw0084;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
		List<List<Integer>> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] item : items1) {
			map.put(item[0], item[1]);
		}
		for (int[] item : items2) {
			map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
		}
		for (int key : map.keySet()) {
			ans.add(Arrays.asList(key, map.get(key)));
		}
		Collections.sort(ans, (a, b) -> Integer.compare(a.get(0), b.get(0)));
		return ans;
	}
}
