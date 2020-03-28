package org.leetcode.problems;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000841_KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean[] seen = new boolean[n];
		int seenCount = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		seen[0] = true;
		seenCount++;
		while(!q.isEmpty()) {
			for (int i = 0, len = q.size(); i < len;i++) {
				int cur = q.poll();
				for (int adj : rooms.get(cur)) {
					if (seen[adj]) continue;
					seen[adj] = true;
					seenCount++;
					q.add(adj);
				}
			}
		}
		return seenCount == n;
	}
}
