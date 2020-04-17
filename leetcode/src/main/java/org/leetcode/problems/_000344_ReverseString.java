package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000344_ReverseString {
	public void reverseString(char[] s) {
		reverse(0, s.length - 1, s);
	}

	void reverse(int left, int right, char[] s) {
		if (left >= right)
			return;
		swap(left, right, s);
		reverse(++left, --right, s);
	}

	void swap(int i, int j, char[] s) {
		char c = s[i];
		s[i] = s[j];
		s[j] = c;
	}
}
