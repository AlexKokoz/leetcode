package org.leetcode.problems;

import java.util.*;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001553_MinimumNumberOfDaysToEatNOranges {

	public int minDays(int n) {
		Map<Integer, Integer> memo = new HashMap<>();
		memo.put(n, 0);
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		while (true) {
			int cur = q.poll();
			int moves = memo.get(cur);
			if (cur == 0)
				return moves;

			if (!memo.containsKey(cur - 1)) {
				memo.put(cur - 1, moves + 1);
				q.add(cur - 1);
			}

			if (cur % 2 == 0 && !memo.containsKey(cur / 2)) {
				memo.put(cur / 2, moves + 1);
				q.add(cur / 2);
			}

			if (cur % 3 == 0 && !memo.containsKey(cur / 3)) {
				memo.put(cur / 3, moves + 1);
				q.add(cur / 3);
			}
		}
	}

}
