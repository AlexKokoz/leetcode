package org.leetcode.contests.weekly.w0172;

import java.util.Stack;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001323_Maximum69Number {
	public int maximum69Number(int num) {
		Stack<Integer> st = new Stack<>();
		while (num > 0) {
			st.add(num % 10);
			num /= 10;
		}
		int ans = 0;
		boolean flag = false;
		while (!st.isEmpty()) {
			int elem = st.pop();
			if (elem == 6 && !flag) {
				elem = 9;
				flag = true;
			}
			ans = ans * 10 + elem;
		}
		return ans;
	}
}
