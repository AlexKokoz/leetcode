package org.leetcode.contests.biweekly.bw0019;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 * 
 */
public class _001345_JumpGameIV {

	public int minJumps(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return 0;

		/*
		 * Store only the last position of consecutive equal elements for the
		 * transitions, since it is not optimal to go anywhere between. \
		 * 
		 * For example for [1,1,1,2,2,1,1,2,2]:
		 * 
		 * 1: {2,6}
		 * 
		 * 2: {4,8}
		 */
		Map<Integer, Queue<Integer>> val2pos = new HashMap<>();
		int k = 0;
		while (k < n) {
			while (k < n - 1 && arr[k] == arr[k + 1])
				k++;
			int val = arr[k];
			Queue<Integer> pos;
			if (val2pos.containsKey(val)) {
				pos = val2pos.get(val);
				pos.add(k);
			} else {
				pos = new LinkedList<>();
				pos.add(k);
			}
			val2pos.put(val, pos);
			k++;
		}
		
		int[] steps = new int[n];
		steps[0] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		// BFS
		while (!q.isEmpty()) {
			for (int i = 0, len = q.size(); i < len; i++) {
				int cur = q.poll();
				
				// Go one step back
				final int prev = cur - 1;
				if (prev >= 0 && steps[prev] == 0) {
					steps[prev] = steps[cur] + 1;
					q.add(prev);
				}
				
				// Go one step front
				final int next = cur + 1;
				if (next == n - 1)
					return steps[cur];
				if (next < n && steps[next] == 0) {
					steps[next] = steps[cur] + 1;
					q.add(next);
				}
				
				// Go to positions with equal value
				Queue<Integer> same = val2pos.get(arr[cur]);
				for (int pos : same) {
					if (pos == cur || steps[pos] > 0)
						continue;
					if (pos == n - 1)
						return steps[cur];
					steps[pos] = steps[cur] + 1;
					q.add(pos);
				}
			}
		}
		return n - 1;
	}
}
