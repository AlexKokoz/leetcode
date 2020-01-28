package org.leetcode.problems;

import java.util.Stack;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000020_ValidParenthensis {

	public boolean isValid(String s) {
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			final char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[')
				stack.add(c);
			else if (c == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (c == '}') {
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
