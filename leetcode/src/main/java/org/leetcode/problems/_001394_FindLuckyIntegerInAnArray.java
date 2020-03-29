package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001394_FindLuckyIntegerInAnArray {
	public int findLucky(int[] arr) {
		int[] f = new int[501];
		for (int x : arr)
			f[x]++;
		for (int i = 500; i >= 1; i--)
			if (f[i] == i)
				return i;
		return -1;
	}
}
