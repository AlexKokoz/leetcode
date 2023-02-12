package org.leetcode.contests.weekly.w0309;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int mostBooked(int n, int[][] meetings) {
		int[] count = new int[n];

		Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));
		PriorityQueue<Integer> openRooms = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			openRooms.add(i);
		}
		// [end, room]
		PriorityQueue<long[]> endings = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0])
				return Long.compare(a[0], b[0]);
			return Long.compare(a[1], b[1]);
		});

		for (int[] meeting : meetings) {
			while (!endings.isEmpty() && endings.peek()[0] < meeting[0]) {
				openRooms.add((int) endings.poll()[1]);
			}
			if (openRooms.isEmpty()) {
				long[] node = endings.poll();
				long start = Math.max(node[0] + 1, meeting[0]);
				long end = start + (meeting[1] - meeting[0]) - 1;
				long room = node[1];
				count[(int) room]++;
				endings.add(new long[] { end, room });
			} else {

				int end = meeting[1] - 1;
				int room = openRooms.poll();
				count[room]++;
				endings.add(new long[] { end, room });
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (count[i] > count[ans]) {
				ans = i;
			}
		}

		return ans;
	}
}
