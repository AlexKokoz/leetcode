package org.leetcode.contests.biweekly.bw0039;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001654_MinimumJumpsToReachHome {
	public int minimumJumps(int[] forbidden, int a, int b, int x) {
		int LIMIT = 4000;
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { 0, 1, 0 }); // pos, status{-1 = back, 1 = forward}, steps
		Set<Integer> rejected = new HashSet<>();
		for (int num : forbidden)
			rejected.add(num);
		Set<Integer> seen = new HashSet<>();
		seen.add(0);
		while (!dq.isEmpty()) {
			int[] move = dq.pollFirst();
			// System.out.println(Arrays.toString(move));
			int pos = move[0];
			int status = move[1];
			int steps = move[2];
			if (pos == x)
				return steps;
			for (int[] nextMove : new int[][] { { pos + a, 1, steps + 1 }, { pos - b, -1, steps + 1 } }) {
				if (rejected.contains(nextMove[0]))
					continue;
				if (seen.contains(nextMove[0] * nextMove[1]))
					continue;
				if (status == -1 && nextMove[1] == -1)
					continue;
				if (nextMove[0] > LIMIT || nextMove[0] < 0)
					continue;
				dq.addLast(nextMove);
				seen.add(nextMove[0] * nextMove[1]);

			}
		}
		return -1;
	}
}
