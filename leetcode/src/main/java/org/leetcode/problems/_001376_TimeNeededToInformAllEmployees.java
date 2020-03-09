package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001376_TimeNeededToInformAllEmployees {
	@SuppressWarnings("unchecked")
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		List<Integer>[] subs = new List[n];
		for (int i = 0; i < n; i++)
			subs[i] = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (manager[i] == -1) continue;
			subs[manager[i]].add(i);
		}
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(headID, 0));
		int max = 0;
		while(!q.isEmpty()) {
			for (int i = 0, len = q.size(); i < len; i++) {
				Node cur = q.poll();
				int supId = cur.id;
				int supTime = cur.time;
				int subTime = supTime + informTime[supId];
				if (subs[supId].isEmpty())
					max = Math.max(max, supTime);
				for (int subId : subs[supId]) 
					q.add(new Node(subId, subTime));
			}
		}
		return max;
		
	}
	
	class Node {
		int id, time;
		public Node(int id, int time) {
			this.id = id;
			this.time = time;
		}
	}
}
