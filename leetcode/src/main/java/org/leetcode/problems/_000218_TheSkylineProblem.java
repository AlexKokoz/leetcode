package org.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000218_TheSkylineProblem {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		int n = buildings.length;
		List<List<Integer>> ans = new ArrayList<>();
		Set<Integer> pending = new HashSet<>(); // ids of intervals that haven't been closed be the sweep line
		PriorityQueue<int[]> maxHeight = new PriorityQueue<>((a, b) -> b[0] - a[0]); // {height, id}
		int[][] events = new int[2 * n][2]; // {id, mode{0=opening, 1=closing}}

		for (int i = 0; i < n; i++) {
			int op = 2 * i;
			int cl = op + 1;
			events[op][0] = i;
			events[op][1] = 0;
			events[cl][0] = i;
			events[cl][1] = 1;
		}
		Arrays.sort(events, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				int pointA = buildings[a[0]][a[1]];
				int pointB = buildings[b[0]][b[1]];
				return pointA - pointB;
			}
		});

		int prevHeight = 0;
		for(int i = 0; i < events.length; ) {
			int point = buildings[events[i][0]][events[i][1]];
			while (i < events.length && point == buildings[events[i][0]][events[i][1]]) {
				int id = events[i][0];
				int mode = events[i][1];
				int height = buildings[id][2];
				if (mode == 0) { // opening
					maxHeight.add(new int[] { height, id });
					pending.add(id);
				} else {  // closing
					pending.remove(id);
					while (!maxHeight.isEmpty() && !pending.contains(maxHeight.peek()[1]))
						maxHeight.poll();
				}
				i++;
			}

			if (!maxHeight.isEmpty()) {
				if (maxHeight.peek()[0] != prevHeight) {
					prevHeight = maxHeight.peek()[0];
					ans.add(Arrays.asList(point, prevHeight));
				}
			} else {
				ans.add(Arrays.asList(point, 0));
				prevHeight = 0;
			}
		}

		return ans;
	}

}
