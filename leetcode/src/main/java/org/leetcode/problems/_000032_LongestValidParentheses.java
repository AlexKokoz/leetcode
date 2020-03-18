package org.leetcode.problems;

import java.util.Stack;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000032_LongestValidParentheses {
	public int longestValidParentheses(String s) {
		final char op = '(';
		final char cl = ')';
		final int O = -2;
		final int C = -1;
		int n = s.length();
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == op || st.isEmpty() || st.peek() == C) {
				st.add((c == op) ? O : C);
			} else if (c == cl) {
				int count = 0;
				if (st.peek() == O) {
					st.pop();
					count += 2;
				} else {
					int top = st.pop();
					if (!st.isEmpty() && st.peek() == O) {
						st.pop();
						count = 2 + top;
					} else {
						st.add(top);
						st.add(C);
					}
				}
				while (!st.isEmpty() && st.peek() > 0)
					count += st.pop();
				st.add(count);
			}
		}

		int max = 0;
		while (!st.isEmpty())
			max = Math.max(max, st.pop());
		return max;
	}
}
