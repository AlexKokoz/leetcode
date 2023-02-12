package org.leetcode.contests.weekly.w0300;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int[][] spiralMatrix(int n, int m, ListNode head) {
		int[][] ans = new int[n][m];
		for (int[] row : ans)
			Arrays.fill(row, -1);
		int r = 0;
		int c = 0;
		int[][] d4 = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int dir = 0;
		while (head != null) {
			ans[r][c] = head.val;
			head = head.next;
			r += d4[dir][0];
			c += d4[dir][1];
			if (r < 0 || c < 0 || r >= n || c >= m || ans[r][c] != -1) {
				r -= d4[dir][0];
				c -= d4[dir][1];
				dir++;
				if (dir >= d4.length) dir = 0;
				r += d4[dir][0];
				c += d4[dir][1];
			}
		}
		return ans;
	}
}
