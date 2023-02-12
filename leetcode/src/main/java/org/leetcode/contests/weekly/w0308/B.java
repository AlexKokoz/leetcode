package org.leetcode.contests.weekly.w0308;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public String removeStars(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char cur = s.charAt(i);
			if (cur == '*') {
				if (!stack.isEmpty())
					stack.pollLast();
			} else {
				stack.addLast(cur);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollFirst());
		}
		return sb.toString();
	}
}
