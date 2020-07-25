package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000909_SnakesAndLadders {
	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		int size = n * n;

		int[][] id = new int[size + 1][2];
		for (int i = 1, r = n - 1, c = 0, step = 1; i < id.length; i++) {
			id[i] = new int[] { r, c };
			c += step;
			if (c == -1 || c == n) {
				r--;
				step *= -1;
				c += step;
			}
		}

		int ans = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		boolean[] seen = new boolean[size + 1];
		seen[1] = true;
		while (!q.isEmpty()) {
			ans++;
			for (int i = 0, end = q.size(); i < end; i++) {
				int from = q.poll();
				for (int to = Math.min(size, from + 6); to >= from + 1; to--) {
					int nr = id[to][0];
					int nc = id[to][1];
					int realTo = to;
					if (board[nr][nc] != -1) {
						realTo = board[nr][nc];
						nr = id[realTo][0];
						nc = id[realTo][1];
					}
					if (seen[realTo])
						continue;
					seen[realTo] = true;
					if (realTo == size)
						return ans;
					q.add(realTo);
				}
			}
		}

		return -1;
	}
}
