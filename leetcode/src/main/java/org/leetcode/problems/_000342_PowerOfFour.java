package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000342_PowerOfFour {
	public boolean isPowerOfFour(int n) {
		return (n & (n - 1)) == 0 && (n & 0x55555555) > 0;
	}
}
