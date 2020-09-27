package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000216_CombinationSumIII {
	List<List<Integer>> ans;
	int n, k;

	public List<List<Integer>> combinationSum3(int k, int n) {
		ans = new ArrayList<>();
		this.n = n;
		this.k = k;
		dfs(0, new ArrayList<>());
		return ans;
	}

	void dfs(int sum, List<Integer> list) {
		if (list.size() == k && sum == n) {
			ans.add(new ArrayList<>(list));
			return;
		}
		if (sum > n)
			return;
		for (int i = (list.isEmpty() ? 1 : list.get(list.size() - 1) + 1); i <= 9; i++) {
			list.add(i);
			dfs(sum + i, list);
			list.remove(list.size() - 1);
		}
	}
}
