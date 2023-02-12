package org.leetcode.contests.weekly.w0314;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public String robotWithString(String s) {
		int[][] next = buildNext(s);
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		int i = 0;
		int n = s.length();
		int smallest = 0;
		for (int ch = 0; ch < 26; ch++) {
			if (next[ch][0] != -1) {
				smallest = ch;
				break;
			}
		}
		while (i < n) {
			while (next[smallest][i] != -1) {
				st.push(s.charAt(i));
				i++;
				if (st.peek() == (char) (smallest + 'a')) {
					sb.append(st.pop());
				}
			}
			smallest = 26;
			for (int ch = 0; ch < 26; ch++) {
				if (next[ch][i] != -1) {
					smallest = ch;
					break;
				}
			}
			while (!st.isEmpty() && st.peek() <= (char) (smallest + 'a')) {
				sb.append(st.pop());
			}
		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		return sb.toString();

	}

	// character skip-list
	// next[c][i] = position of next occurrence of char c in [i, word.length() - 1]
	// -1 if no further occurrence
	// initialize search with pos = 0; add 1 after to proceed(to cover case where
	// searching for the same letter subsequently)
	static int[][] buildNext(String word) {
		int[][] next = new int[26][word.length() + 1];
		for (int[] row : next)
			Arrays.fill(row, -1);
		for (int j = word.length() - 1; j >= 0; j--) {
			int c = word.charAt(j) - 'a';
			for (int k = 0; k < 26; k++)
				next[k][j] = next[k][j + 1];
			next[c][j] = j;
		}
		return next;
	}
}
