package org.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author akokozidis
 *
 */
public class _000685_RedundantConnectionII {
	Map<Integer, Integer> childToParent;
	Map<Integer, Integer>[] order;
	List<int[]> orbit;

	@SuppressWarnings("unchecked")
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		childToParent = new HashMap<>();
		List<int[]> candidates = new LinkedList<>();
		order = new Map[n + 1];
		orbit = new LinkedList<>();
		for (int i = 0; i < order.length; i++)
			order[i] = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int[] e = edges[i];
			if (childToParent.containsKey(e[1])) {
				candidates.add(new int[] { childToParent.get(e[1]), e[1] });
				candidates.add(e);
			} else
				childToParent.put(e[1], e[0]);
			order[e[0]].put(e[1], i);
		}

		if (candidates.size() == 2) {
			int[] first = candidates.get(0);
			int[] second = candidates.get(1);
			if (detectCycle(first))
				return first;
			return second; // no cycle
		}

		for (int[] e : edges)
			if (detectCycle(e))
				return getMostRecentEdge();
		return null;
	}

	boolean detectCycle(int[] e) {
		Set<Integer> marked = new HashSet<>();
		orbit.clear();
		Integer par = e[0];
		Integer ch = e[1];
		while (par != null && !marked.contains(par)) {
			marked.add(par);
			orbit.add(new int[] { par, ch });
			ch = par;
			par = childToParent.get(ch);
		}
		if (par == null)
			return false;
		orbit.add(new int[] { par, ch });
		return true;
	}

	int[] getMostRecentEdge() {
		if (orbit == null || orbit.isEmpty())
			return null;
		int max = -1; // most recent(largest) edge index in input array
		int[] mostRecentEdge = null;
		for (int[] e : orbit) {
			if (order[e[0]].get(e[1]) > max) {
				max = order[e[0]].get(e[1]);
				mostRecentEdge = new int[] { e[0], e[1] };
			}
		}
		return mostRecentEdge;
	}
}
