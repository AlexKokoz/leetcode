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
public class _000009_PalindromeNumber {
	public boolean isPalindrome(int x) {
		List<Integer> list = new LinkedList<>();
		while(x > 0) {
			list.add(x % 10);
			x /= 10;
		}
		int n = list.size();
		for (int i = 0, mid = n / 2; i < mid; i++)
			if (list.get(i) != list.get(n - 1 - i))
				return false;
		return true;
	}
}
