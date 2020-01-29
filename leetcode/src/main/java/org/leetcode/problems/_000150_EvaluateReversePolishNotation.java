package org.leetcode.problems;

import java.util.Stack;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000150_EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		final Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			int op1, op2;
			switch (token) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				op2 = stack.pop();
				op1 = stack.pop();
				stack.push(op1 - op2);
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				op2 = stack.pop();
				op1 = stack.pop();
				stack.push(op1 / op2);
				break;
			default:
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}
