package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001486_XOROperationInAnArray {
	public int xorOperation(int n, int start) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans ^= (start + 2 * i);
		}
		return ans;
	}
}
