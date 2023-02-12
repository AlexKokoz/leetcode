package org.leetcode.contests.biweekly.bw0071;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	int ans = Integer.MAX_VALUE;
	int move, push, target;

	public int minCostSetTime(int start, int move, int push, int target) {
		this.push = push;
		this.move = move;
		this.target = target;
		dfs(String.valueOf(start), push);
		dfs("", 0);
		return ans;
	}

	void dfs(String pressed, int cost) {
		// check
		int n = pressed.length();
		if (n > 0) {
			int m = n > 2 ? Integer.parseInt(pressed.substring(0, n - 2)) : 0;
			int s = n > 2 ? Integer.parseInt(pressed.substring(n - 2)) : Integer.parseInt(pressed);
			int dur = m * 60 + s;
			if (dur == target) {
				ans = Math.min(ans, cost);
			}
		}

		if (pressed.length() == 4)
			return;

		for (int i = 0; i < 10; i++) {
			if (pressed.length() > 0 && Integer.parseInt(pressed.substring(n - 1, n)) == i) {
				dfs(pressed + i, cost + push);
			} else {
				dfs(pressed + i, cost + push + move);
			}
		}
	}
}
