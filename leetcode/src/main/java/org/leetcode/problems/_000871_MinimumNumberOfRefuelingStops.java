package org.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000871_MinimumNumberOfRefuelingStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		if (startFuel >= target)
			return 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[1] < b[1]) return 1;
				if (a[1] > b[1]) return -1;
				return 0;
			}
		});
		int min = 0;
		for (int[] station : stations) {
			while (!pq.isEmpty() && startFuel < station[0]) {
				if (startFuel >= target)
					return min;
				int[] maxStation = pq.poll();
				startFuel += maxStation[1];
				min++;
			}
			if (startFuel < station[0])
				return -1; // cannot reach target
			pq.add(station);
		}

		while (!pq.isEmpty() && startFuel < target) {
			int[] maxStation = pq.poll();
			startFuel += maxStation[1];
			min++;
		}
		if (startFuel < target)
			return -1; // cannot reach target
		return min;

	}
}
