package org.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000399_EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		double[] ans = new double[queries.size()];

		// adj list
		Map<String, Map<String, Double>> adj = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String varA = equations.get(i).get(0);
			String varB = equations.get(i).get(1);
			double val = values[i];
			adj.computeIfAbsent(varA, k -> new HashMap<>()).put(varB, val);
			adj.computeIfAbsent(varB, k -> new HashMap<>()).put(varA, 1 / val);
		}

		for (int i = 0; i < queries.size(); i++) {
			String varA = queries.get(i).get(0);
			String varB = queries.get(i).get(1);
			boolean[] found = new boolean[1];
			if (!adj.containsKey(varA) || !adj.containsKey(varB)) {
				ans[i] = -1;
			} else {
				double[] result = new double[1];
				Set<String> seen = new HashSet<>();
				seen.add(varA);
				dfs(varA, varB, adj, 1, result, found, seen);
				ans[i] = result[0] == 0 ? -1 : result[0];
			}
		}

		return ans;

	}

	void dfs(String now, String dest, Map<String, Map<String, Double>> adj, double cur, double[] result,
			boolean[] found, Set<String> seen) {
		if (found[0])
			return;
		if (now.equals(dest) || cur == 0) {
			result[0] = cur;
			found[0] = true;
			return;
		}
		for (String next : adj.get(now).keySet()) {
			if (seen.contains(next))
				continue;
			seen.add(next);
			double val = adj.get(now).get(next);
			dfs(next, dest, adj, cur * val, result, found, seen);
			seen.remove(next);
		}
	}
}
