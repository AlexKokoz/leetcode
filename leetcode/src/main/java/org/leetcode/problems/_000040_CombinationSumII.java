package org.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000040_CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new LinkedList<>();
		Map<Integer, Integer> val2freq = new HashMap<>();
		for (int x : candidates) {
			int f = val2freq.getOrDefault(x, 0) + 1;
			val2freq.put(x, f);
		}
		int[] uniq = new int[val2freq.size()];
		int i = 0;
		for (int key : val2freq.keySet())
			uniq[i++] = key;
		Arrays.sort(uniq);
		dfs(uniq, val2freq, ans, new LinkedList<>(), 0, 0, target);
		return ans;
	}

	void dfs(int[] uniq, Map<Integer, Integer> val2freq, List<List<Integer>> ans, List<Integer> list, int d, int curSum,
			int targetSum) {
		if (curSum == targetSum) {
			ans.add(new LinkedList<>(list));
			return;
		}
		if (curSum > targetSum || d >= uniq.length)
			return;
		for (int i = d; i < uniq.length; i++) {
			for (int j = 1, count = val2freq.get(uniq[i]); j <= count; j++) {
				list.add(uniq[i]);
				dfs(uniq, val2freq, ans, list, i + 1, curSum + j * uniq[i], targetSum);

			}
			for (int j = 1, count = val2freq.get(uniq[i]); j <= count; j++)
				list.remove(list.size() - 1);
		}
	}
}
