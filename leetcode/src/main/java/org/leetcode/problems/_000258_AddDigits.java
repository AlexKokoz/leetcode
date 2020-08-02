package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000258_AddDigits {
	public int addDigits(int num) {
		return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
	}
}
