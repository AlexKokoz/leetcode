package org.leetcode.contests.biweekly.bw0033;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001557_MinimumNumberOfVerticesToReachAllNodes {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		int[] indeg = new int[n];
		for (List<Integer> edge : edges) {
			indeg[edge.get(1)]++;
		}
		List<Integer> ans = new ArrayList<>();
		for(int i = 0; i < n; i++) 
			if(indeg[i] == 0) ans.add(i);
		return ans;
	}
}
