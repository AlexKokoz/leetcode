package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000802_FindEventualSafeStates {

	enum State {
		Unprocessed, Invalid, Valid;
	}

	public List<Integer> eventualSafeNodes(int[][] g) {
		int n = g.length;
		State[] state = new State[n];
		for (int i = 0; i < n; i++) {
			dfs(i, state, g);
		}
		List<Integer> ans = new LinkedList<>();
		for (int i = 0; i < n; i++)
			if (state[i] == State.Valid)
				ans.add(i);
		return ans;
	}

	void dfs(int cur, State[] state, int[][] g) {
		if (state[cur] == State.Invalid || state[cur] == State.Valid)
			return;
		if (g[cur].length == 0) {
			state[cur] = State.Valid;
			return;
		}
		state[cur] = State.Invalid;
		for (int adj : g[cur]) {
			dfs(adj, state, g);
			if (state[adj] == State.Invalid)
				return;
		}
		state[cur] = State.Valid;
	}
}
