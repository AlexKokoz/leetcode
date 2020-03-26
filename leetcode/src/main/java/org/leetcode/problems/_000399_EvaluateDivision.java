package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000399_EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		// create adjacency map; each String vertex mapped to a map of vertex-weight
		// pairs
		Map<String, Map<String, Double>> adj = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			List<String> e = equations.get(i);
			adj.computeIfAbsent(e.get(0), k -> new HashMap<>()).put(e.get(1), values[i]);
			adj.computeIfAbsent(e.get(1), k -> new HashMap<>()).put(e.get(0), 1 / values[i]);
		}

		// dfs from numerator to denominator
		double[] ans = new double[queries.size()];
		Arrays.fill(ans, 1);
		for (int i = 0; i < queries.size(); i++) {
			List<String> q = queries.get(i);
			boolean[] terminate = new boolean[1];
			Stack<Double> path = new Stack<>();
			if (!adj.containsKey(q.get(0)) || !adj.containsKey(q.get(1))) {
				ans[i] = -1;
				continue;
			} else if (q.get(0).equals(q.get(1))) {
				continue;
			}
			dfs("", q.get(0), q.get(1), adj, path, terminate);
			if (terminate[0]) {
				while (!path.isEmpty())
					ans[i] *= path.pop();
			} else
				ans[i] = -1;
		}
		return ans;
	}

	void dfs(String p, String ch, String target, Map<String, Map<String, Double>> adj, Stack<Double> path,
			boolean[] terminate) {
		if (terminate[0])
			return;
		for (String nch : adj.get(ch).keySet()) {
			if (p.equals(nch))
				continue;
			double val = adj.get(ch).get(nch);
			path.add(val);
			if (nch.equals(target)) {
				terminate[0] = true;
				return;
			}
			dfs(ch, nch, target, adj, path, terminate);
			if (terminate[0])
				return;
			path.pop();
		}
	}
}
